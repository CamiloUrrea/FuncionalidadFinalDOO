package co.edu.uco.backend.data.dao.entity.organizaciondeportiva.impl.postgresql;

import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.DataBackEndException;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.OrganizacionDeportivaDAO;
import co.edu.uco.backend.entity.EstadoVerificacionEntity;
import co.edu.uco.backend.entity.OrganizacionDeportivaEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrganizacionDeportivaPostgreSQLDAO implements OrganizacionDeportivaDAO {

    private Connection connection;

    public OrganizacionDeportivaPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(OrganizacionDeportivaEntity entity) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO organizaciondeportiva(codigoorganizacion, nombre, usuario, contrasena, prefijo, telefono, documentoexistencia, correo, paginaweb, codigoestadover)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,entity.getId());
            sentenciaPreparada.setString(2,entity.getNombre());
            sentenciaPreparada.setString(3,entity.getUsername());
            sentenciaPreparada.setString(4,entity.getContrasena());
            sentenciaPreparada.setString(5,entity.getPrefijoTelefono());
            sentenciaPreparada.setString(6,entity.getTelefono());
            sentenciaPreparada.setString(7,entity.getDocumentoExistencia());
            sentenciaPreparada.setString(8,entity.getCorreoAdministrativo());
            sentenciaPreparada.setString(9,entity.getPaginaWeb());
            sentenciaPreparada.setObject(10,entity.getEstadoVerificacion());


            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de registrar la nueva informacion de la organizacion deportiva en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva informacion de la organizacion deportiva en la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        }catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ingresar la nueva infromacion de la organizacion deportiva en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de ingresar la nueva informacion de la organizacion deportiva en la base de datos    ";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void eliminar(UUID organizacionDeportivaId) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM organizaciondeportiva WHERE codigoorganizacion = ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,organizacionDeportivaId);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de hacer un DELETE en la tabla de organizacion deportiva en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar definitivamente informacion de la organizacion deportiva deseada de la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        }catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer un DELETE en la tabla de organizacion deportiva en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de borrar definitivamente la informacion de la organizacion deportiva en la base de datos    ";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<OrganizacionDeportivaEntity> consultar(OrganizacionDeportivaEntity filtro) throws BackEndException {
        var lista = new ArrayList<OrganizacionDeportivaEntity>();
        var sql = new StringBuilder("""
        SELECT codigoorganizacion
             , nombre
             , usuario
             , contrasena
             , prefijo
             , telefono
             , documentoexistencia
             , correo
             , paginaweb
             , codigoestadover
        FROM organizaciondeportiva
        WHERE 1=1
        """);

        boolean filtrarId              = !UtilUUID.esValorDefecto(filtro.getId());
        boolean filtrarNombre          = !UtilTexto.getInstance().estaVacia(filtro.getNombre());
        boolean filtrarUsername        = !UtilTexto.getInstance().estaVacia(filtro.getUsername());
        boolean filtrarPrefijo         = !UtilTexto.getInstance().estaVacia(filtro.getPrefijoTelefono());
        boolean filtrarTelefono        = !UtilTexto.getInstance().estaVacia(filtro.getTelefono());
        boolean filtrarDocumento       = !UtilTexto.getInstance().estaVacia(filtro.getDocumentoExistencia());
        boolean filtrarCorreo          = !UtilTexto.getInstance().estaVacia(filtro.getCorreoAdministrativo());
        boolean filtrarPaginaWeb       = !UtilTexto.getInstance().estaVacia(filtro.getPaginaWeb());
        boolean filtrarEstadoVerif     = filtro.getEstadoVerificacion() != null
                && !UtilUUID.esValorDefecto(filtro.getEstadoVerificacion().getId());

        // Agregar condiciones dinámicas
        if (filtrarId)            sql.append(" AND codigoorganizacion = ?");
        if (filtrarNombre)        sql.append(" AND nombre ILIKE ?");
        if (filtrarUsername)      sql.append(" AND usuario = ?");
        if (filtrarPrefijo)       sql.append(" AND prefijo = ?");
        if (filtrarTelefono)      sql.append(" AND telefono = ?");
        if (filtrarDocumento)     sql.append(" AND documentoexistencia = ?");
        if (filtrarCorreo)        sql.append(" AND correo ILIKE ?");
        if (filtrarPaginaWeb)     sql.append(" AND paginaweb ILIKE ?");
        if (filtrarEstadoVerif)   sql.append(" AND codigoestadover = ?");

        try (var ps = connection.prepareStatement(sql.toString())) {
            int idx = 1;
            if (filtrarId) {
                ps.setObject(idx++, filtro.getId());
            }
            if (filtrarNombre) {
                ps.setString(idx++, "%" + filtro.getNombre().trim() + "%");
            }
            if (filtrarUsername) {
                ps.setString(idx++, filtro.getUsername().trim());
            }
            if (filtrarPrefijo) {
                ps.setString(idx++, filtro.getPrefijoTelefono().trim());
            }
            if (filtrarTelefono) {
                ps.setString(idx++, filtro.getTelefono().trim());
            }
            if (filtrarDocumento) {
                ps.setString(idx++, filtro.getDocumentoExistencia().trim());
            }
            if (filtrarCorreo) {
                ps.setString(idx++, "%" + filtro.getCorreoAdministrativo().trim() + "%");
            }
            if (filtrarPaginaWeb) {
                ps.setString(idx++, "%" + filtro.getPaginaWeb().trim() + "%");
            }
            if (filtrarEstadoVerif) {
                ps.setObject(idx++, filtro.getEstadoVerificacion().getId());
            }

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    var entidad = new OrganizacionDeportivaEntity();
                    entidad.setId(UtilUUID.convertirAUUID(rs.getString("codigoorganizacion")));
                    entidad.setNombre(rs.getString("nombre"));
                    entidad.setUsername(rs.getString("usuario"));
                    entidad.setContrasena(rs.getString("contrasena"));
                    entidad.setPrefijoTelefono(rs.getString("prefijo"));
                    entidad.setTelefono(rs.getString("telefono"));
                    entidad.setDocumentoExistencia(rs.getString("documentoexistencia"));
                    entidad.setCorreoAdministrativo(rs.getString("correo"));
                    entidad.setPaginaWeb(rs.getString("paginaweb"));

                    var estadoId = UtilUUID.convertirAUUID(rs.getString("codigoestadover"));
                    var estado = new EstadoVerificacionEntity(estadoId, null);
                    entidad.setEstadoVerificacion(estado);

                    lista.add(entidad);
                }
            }
        } catch (SQLException ex) {
            throw DataBackEndException.reportar(
                    "Se ha presentado un problema tratando de consultar organizaciones deportivas en la base de datos",
                    "SQLException al ejecutar SELECT en tabla organizaciondeportiva",
                    ex
            );
        } catch (Exception ex) {
            throw DataBackEndException.reportar(
                    "Se ha presentado un problema inesperado al consultar organizaciones deportivas",
                    "Excepción NO CONTROLADA al ejecutar SELECT en tabla organizaciondeportiva",
                    ex
            );
        }

        return lista;
    }

    @Override
    public List<OrganizacionDeportivaEntity> listAll() throws BackEndException {
        var lista = new ArrayList<OrganizacionDeportivaEntity>();
        var sql = new StringBuilder();
        sql.append("""
        SELECT codigoorganizacion
             , nombre
             , usuario
             , contrasena
             , prefijo
             , telefono
             , documentoexistencia
             , correo
             , paginaweb
             , codigoestadover
        FROM organizaciondeportiva
        """);

        try (var ps = connection.prepareStatement(sql.toString());
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                var entidad = new OrganizacionDeportivaEntity();
                entidad.setId(UtilUUID.convertirAUUID(rs.getString("codigoorganizacion")));
                entidad.setNombre(rs.getString("nombre"));
                entidad.setUsername(rs.getString("usuario"));
                entidad.setContrasena(rs.getString("contrasena"));
                entidad.setPrefijoTelefono(rs.getString("prefijo"));
                entidad.setTelefono(rs.getString("telefono"));
                entidad.setDocumentoExistencia(rs.getString("documentoexistencia"));
                entidad.setCorreoAdministrativo(rs.getString("correo"));
                entidad.setPaginaWeb(rs.getString("paginaweb"));

                var estadoId = UtilUUID.convertirAUUID(rs.getString("codigoestadover"));
                var estado = new EstadoVerificacionEntity(estadoId, null);
                entidad.setEstadoVerificacion(estado);

                lista.add(entidad);
            }
        } catch (SQLException ex) {
            var mensajeTecnico = "Se presentó una SQLException al listar todas las organizaciones deportivas.";
            var mensajeUsuario = "No se pudo obtener la lista de organizaciones deportivas.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, ex);
        } catch (Exception ex) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todas las organizaciones deportivas.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar organizaciones deportivas.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, ex);
        }
        return lista;
    }



    @Override
    public OrganizacionDeportivaEntity consultarPorId(UUID codigoOrganizacion) throws BackEndException {
        var entidadRetorno = new OrganizacionDeportivaEntity();
        var sql = new StringBuilder();
        sql.append("""
        SELECT codigoorganizacion
             , nombre
             , usuario
             , contrasena
             , prefijo
             , telefono
             , documentoexistencia
             , correo
             , paginaweb
             , codigoestadover
        FROM organizaciondeportiva
        WHERE codigoorganizacion = ?
        """);

        try (var ps = connection.prepareStatement(sql.toString())) {
            ps.setObject(1, codigoOrganizacion);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    entidadRetorno.setId(UtilUUID.convertirAUUID(rs.getString("codigoorganizacion")));
                    entidadRetorno.setNombre(rs.getString("nombre"));
                    entidadRetorno.setUsername(rs.getString("usuario"));
                    entidadRetorno.setContrasena(rs.getString("contrasena"));
                    entidadRetorno.setPrefijoTelefono(rs.getString("prefijo"));
                    entidadRetorno.setTelefono(rs.getString("telefono"));
                    entidadRetorno.setDocumentoExistencia(rs.getString("documentoexistencia"));
                    entidadRetorno.setCorreoAdministrativo(rs.getString("correo"));
                    entidadRetorno.setPaginaWeb(rs.getString("paginaweb"));

                    UUID estadoId = UtilUUID.convertirAUUID(rs.getString("codigoestadover"));
                    var estado = new EstadoVerificacionEntity(estadoId, null);
                    entidadRetorno.setEstadoVerificacion(estado);
                }
            }
        } catch (SQLException ex) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la organización deportiva deseada en la base de datos.";
            var mensajeTecnico = "SQLException al ejecutar SELECT en tabla organizaciondeportiva";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, ex);
        } catch (Exception ex) {
            var mensajeUsuario = "Se ha presentado un problema inesperado al consultar la organización deportiva.";
            var mensajeTecnico = "Excepción NO CONTROLADA al ejecutar SELECT en tabla organizaciondeportiva";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, ex);
        }
        return entidadRetorno;
    }





    @Override
    public void modificar(UUID organizacionDeportivaId, OrganizacionDeportivaEntity entity) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE organizaciondeportiva SET nombre = ?, usuario = ?, contrasena = ?,prefijo = ?, telefono = ?, documentoexistencia = ?, correo = ?, paginaweb = ?, codigoestadover = ? WHERE codigoorganizacion = ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,organizacionDeportivaId);
            sentenciaPreparada.setString(2,entity.getNombre());
            sentenciaPreparada.setString(3,entity.getUsername());
            sentenciaPreparada.setString(4,entity.getContrasena());
            sentenciaPreparada.setString(5,entity.getPrefijoTelefono());
            sentenciaPreparada.setString(6,entity.getTelefono());
            sentenciaPreparada.setString(7,entity.getDocumentoExistencia());
            sentenciaPreparada.setString(8,entity.getCorreoAdministrativo());
            sentenciaPreparada.setString(9,entity.getPaginaWeb());
            sentenciaPreparada.setObject(10,entity.getEstadoVerificacion());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de modificar la nueva informacion de la organizacion deportiva deseada en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la nueva informacion de la organizacion deportiva deseada en la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        }catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer un UPDATE de la organizacion deportiva deseada en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de modificar la nueva informacion de la organizacion deportiva deseada en la base de datos    ";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

    }
}
