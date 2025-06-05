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
import java.util.Optional;
import java.util.UUID;

public class OrganizacionDeportivaPostgreSQLDAO implements OrganizacionDeportivaDAO {

    private Connection connection;

    public OrganizacionDeportivaPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(OrganizacionDeportivaEntity entity) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append(
                "INSERT INTO doodb.organizaciondeportiva(" +
                        "id, nombre, username, contrasena, prefijo, telefono, " +
                        "documentoexistencia, correoadministrativo, paginaweb, codigoestadover)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );

        try (var ps = connection.prepareStatement(sentenciaSQL.toString())) {
            ps.setObject(1, entity.getId());
            ps.setString(2, entity.getNombre());
            ps.setString(3, entity.getUsername());
            ps.setString(4, entity.getContrasena());
            ps.setString(5, entity.getPrefijoTelefono());
            ps.setString(6, entity.getTelefono());
            ps.setString(7, entity.getDocumentoExistencia());
            ps.setString(8, entity.getCorreoAdministrativo());
            ps.setString(9, entity.getPaginaWeb());
            ps.setObject(10, entity.getEstadoVerificacion().getId());

            ps.executeUpdate();
        } catch (SQLException exception) {
            // 1) Imprime por consola (o en tu log) la traza completa del error
            exception.printStackTrace();
            // 2) Devuelve el mensaje técnico exacto al reportar el error (para que no sea genérico)
            var mensajeTecnico = "SQLException en INSERT: " + exception.getMessage();
            var mensajeUsuario = "Error al intentar insertar en doodb.organizaciondeportiva. " +
                    "Ver detalle técnico en los logs.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);



    } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ingresar la nueva información de la organización deportiva en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de ingresar la nueva información de la organización deportiva en la base de datos";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void eliminar(UUID organizacionDeportivaId) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM doodb.organizaciondeportiva WHERE id = ?");
        try (var ps = connection.prepareStatement(sentenciaSQL.toString())) {
            ps.setObject(1, organizacionDeportivaId);
            ps.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de hacer un DELETE en la tabla de organización deportiva en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar definitivamente información de la organización deportiva deseada de la fuente de datos";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer un DELETE en la tabla de organización deportiva en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de borrar definitivamente la información de la organización deportiva en la base de datos";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<OrganizacionDeportivaEntity> consultar(OrganizacionDeportivaEntity filtro) throws BackEndException {
        var lista = new ArrayList<OrganizacionDeportivaEntity>();
        var sql = new StringBuilder("""
            SELECT id
                 , nombre
                 , username
                 , contrasena
                 , prefijo
                 , telefono
                 , documentoexistencia
                 , correoadministrativo
                 , paginaweb
                 , codigoestadover
            FROM doodb.organizaciondeportiva
            WHERE 1=1
            """);

        boolean filtrarId            = !UtilUUID.esValorDefecto(filtro.getId());
        boolean filtrarNombre        = !UtilTexto.getInstance().estaVacia(filtro.getNombre());
        boolean filtrarUsername      = !UtilTexto.getInstance().estaVacia(filtro.getUsername());
        boolean filtrarPrefijo       = !UtilTexto.getInstance().estaVacia(filtro.getPrefijoTelefono());
        boolean filtrarTelefono      = !UtilTexto.getInstance().estaVacia(filtro.getTelefono());
        boolean filtrarDocumento     = !UtilTexto.getInstance().estaVacia(filtro.getDocumentoExistencia());
        boolean filtrarCorreo        = !UtilTexto.getInstance().estaVacia(filtro.getCorreoAdministrativo());
        boolean filtrarPaginaWeb     = !UtilTexto.getInstance().estaVacia(filtro.getPaginaWeb());
        boolean filtrarEstadoVerif   = filtro.getEstadoVerificacion() != null
                && !UtilUUID.esValorDefecto(filtro.getEstadoVerificacion().getId());

        if (filtrarId)          sql.append(" AND id = ?");
        if (filtrarNombre)      sql.append(" AND nombre ILIKE ?");
        if (filtrarUsername)    sql.append(" AND username = ?");
        if (filtrarPrefijo)     sql.append(" AND prefijo = ?");
        if (filtrarTelefono)    sql.append(" AND telefono = ?");
        if (filtrarDocumento)   sql.append(" AND documentoexistencia = ?");
        if (filtrarCorreo)      sql.append(" AND correoadministrativo ILIKE ?");
        if (filtrarPaginaWeb)   sql.append(" AND paginaweb ILIKE ?");
        if (filtrarEstadoVerif) sql.append(" AND codigoestadover = ?");

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
                    entidad.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                    entidad.setNombre(rs.getString("nombre"));
                    entidad.setUsername(rs.getString("username"));
                    entidad.setContrasena(rs.getString("contrasena"));
                    entidad.setPrefijoTelefono(rs.getString("prefijo"));
                    entidad.setTelefono(rs.getString("telefono"));
                    entidad.setDocumentoExistencia(rs.getString("documentoexistencia"));
                    entidad.setCorreoAdministrativo(rs.getString("correoadministrativo"));
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
            SELECT id
                 , nombre
                 , username
                 , contrasena
                 , prefijo
                 , telefono
                 , documentoexistencia
                 , correoadministrativo
                 , paginaweb
                 , codigoestadover
            FROM doodb.organizaciondeportiva
            """);

        try (var ps = connection.prepareStatement(sql.toString());
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                var entidad = new OrganizacionDeportivaEntity();
                entidad.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                entidad.setNombre(rs.getString("nombre"));
                entidad.setUsername(rs.getString("username"));
                entidad.setContrasena(rs.getString("contrasena"));
                entidad.setPrefijoTelefono(rs.getString("prefijo"));
                entidad.setTelefono(rs.getString("telefono"));
                entidad.setDocumentoExistencia(rs.getString("documentoexistencia"));
                entidad.setCorreoAdministrativo(rs.getString("correoadministrativo"));
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
            SELECT id
                 , nombre
                 , username
                 , contrasena
                 , prefijo
                 , telefono
                 , documentoexistencia
                 , correoadministrativo
                 , paginaweb
                 , codigoestadover
            FROM doodb.organizaciondeportiva
            WHERE id = ?
            """);

        try (var ps = connection.prepareStatement(sql.toString())) {
            ps.setObject(1, codigoOrganizacion);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    entidadRetorno.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                    entidadRetorno.setNombre(rs.getString("nombre"));
                    entidadRetorno.setUsername(rs.getString("username"));
                    entidadRetorno.setContrasena(rs.getString("contrasena"));
                    entidadRetorno.setPrefijoTelefono(rs.getString("prefijo"));
                    entidadRetorno.setTelefono(rs.getString("telefono"));
                    entidadRetorno.setDocumentoExistencia(rs.getString("documentoexistencia"));
                    entidadRetorno.setCorreoAdministrativo(rs.getString("correoadministrativo"));
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
    public boolean existsByUsername(String username) throws BackEndException {
        var sql = "SELECT 1 FROM doodb.organizaciondeportiva WHERE username = ?";
        try (var pst = connection.prepareStatement(sql)) {
            pst.setString(1, username.trim());
            try (var rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new BackEndException("Error verificando existencia de username.", e);
        }
    }

    public boolean existsByCorreo(String correoAdministrativo) throws BackEndException {
                var sql = "SELECT 1 FROM doodb.organizaciondeportiva WHERE correoadministrativo = ?";
                try (var pst = connection.prepareStatement(sql)) {
                        pst.setString(1, correoAdministrativo.trim());
                        try (var rs = pst.executeQuery()) {
                                return rs.next();
                            }
                    } catch (SQLException e) {
                        throw new BackEndException("Error verificando existencia de correo administrativo.", e);
                    }
            }

    @Override
    public boolean existsByRut(String rut) throws BackEndException {
        var sql = "SELECT 1 FROM doodb.organizaciondeportiva WHERE documentoexistencia = ?";
        try (var pst = connection.prepareStatement(sql)) {
            pst.setString(1, rut.trim());
            try (var rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new BackEndException("Error verificando existencia de RUT.", e);
        }
    }

    @Override
    public Optional<OrganizacionDeportivaEntity> consultarPorUsername(String username) throws BackEndException {
        var sql = """
        SELECT 
            o.id,
            o.nombre,
            o.username,
            o.contrasena,
            o.prefijo,
            o.telefono,
            o.documentoexistencia,
            o.correoadministrativo,
            o.paginaweb,
            o.codigoestadover,
            e.nombre AS estado_nombre
        FROM doodb.organizaciondeportiva o
        JOIN doodb.estadoverificacion e
          ON e.id = o.codigoestadover
        WHERE o.username = ?
    """;

        try (var pst = connection.prepareStatement(sql)) {
            pst.setString(1, username.trim());

            try (var rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Construimos la entidad incluyendo el nombre del estado:
                    var entidad = new OrganizacionDeportivaEntity(
                            UtilUUID.convertirAUUID(rs.getString("id")),            // id
                            rs.getString("nombre"),                                   // nombre
                            rs.getString("username"),                                 // username
                            rs.getString("contrasena"),                               // contrasena
                            rs.getString("prefijo"),                                  // prefijo
                            rs.getString("telefono"),                                 // telefono
                            rs.getString("documentoexistencia"),                      // documentoExistencia
                            rs.getString("correoadministrativo"),                     // correoAdministrativo
                            rs.getString("paginaweb"),                                // paginaWeb
                            List.of(),                                                // encargados (no usado aquí)
                            List.of(),                                                // canchas (no usado aquí)
                            new EstadoVerificacionEntity(
                                    UtilUUID.convertirAUUID(rs.getString("codigoestadover")), // estado.id
                                    rs.getString("estado_nombre")                             // estado.nombre recuperado
                            )
                    );
                    return Optional.of(entidad);
                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new BackEndException("Error consultando organización por username.", e);
        }
    }


    @Override
    public void modificar(UUID organizacionDeportivaId, OrganizacionDeportivaEntity entity) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append(
                "UPDATE doodb.organizaciondeportiva " +
                        "SET nombre = ?, username = ?, contrasena = ?, prefijo = ?, telefono = ?, " +
                        "documentoexistencia = ?, correoadministrativo = ?, paginaweb = ?, codigoestadover = ? " +
                        "WHERE id = ?"
        );
        try (var ps = connection.prepareStatement(sentenciaSQL.toString())) {
            ps.setString(1, entity.getNombre());
            ps.setString(2, entity.getUsername());
            ps.setString(3, entity.getContrasena());
            ps.setString(4, entity.getPrefijoTelefono());
            ps.setString(5, entity.getTelefono());
            ps.setString(6, entity.getDocumentoExistencia());
            ps.setString(7, entity.getCorreoAdministrativo());
            ps.setString(8, entity.getPaginaWeb());
            ps.setObject(9, entity.getEstadoVerificacion().getId());
            ps.setObject(10, organizacionDeportivaId);

            ps.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de modificar la información de la organización deportiva deseada en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información de la organización deportiva deseada en la fuente de datos";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer un UPDATE de la organización deportiva deseada en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de modificar la información de la organización deportiva deseada en la base de datos";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}

