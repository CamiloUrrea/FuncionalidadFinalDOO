package co.edu.uco.backend.data.dao.entity.cliente.impl.postgresql;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.DataBackEndException;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.backend.data.dao.entity.cliente.ClienteDAO;
import co.edu.uco.backend.entity.ClienteEntity;
import jdk.jshell.execution.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ClientePostgreSQLDAO implements ClienteDAO {

    private final Connection connection;

    public ClientePostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(ClienteEntity entity) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO cliente(codigocliente, nombre, username, contrasena, prefijotelefono, telefono)" +
                " VALUES (?, ?, ?, ?, ?, ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,entity.getId());
            sentenciaPreparada.setString(2,entity.getNombre());
            sentenciaPreparada.setString(3,entity.getUsername());
            sentenciaPreparada.setString(4,entity.getContrasena());
            sentenciaPreparada.setString(5,entity.getPrefijoTelefono());
            sentenciaPreparada.setString(6,entity.getTelefono());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de registrar la nueva informacion del Cliente en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva informacion del Cliente en la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        }catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ingresar la nueva infromacion del Cliente en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de ingresar la nueva informacion del Cliente en la base de datos    ";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void eliminar(UUID codigocliente) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM cliente WHERE codigocliente = ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,codigocliente);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de hacer un DELETE en la tabla del cliente en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar definitivamente informacion del cliente deseada de la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        }catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer un DELETE en la tabla del cliente en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de borrar definitivamente la informacion del cliente en la base de datos    ";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }









    @Override
    public List<ClienteEntity> consultar(ClienteEntity entity) {
        return List.of();
    }

    @Override
    public ClienteEntity consultarPorId(UUID codigocliente) throws BackEndException {
        var ClienteEntityRetorno = new ClienteEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT * FROM cliente WHERE codigocliente = ?)");

        try(var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){

            sentenciaPreparada.setObject(1, codigocliente);


            try (var cursorResultados = sentenciaPreparada.executeQuery()){

                if(cursorResultados.next()){
                    ClienteEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("codigocliente")));
                    ClienteEntityRetorno.setNombre(cursorResultados.getString("nombre"));
                    ClienteEntityRetorno.setUsername(cursorResultados.getString("username"));
                    ClienteEntityRetorno.setContrasena(cursorResultados.getString("contrasena"));
                    ClienteEntityRetorno.setPrefijoTelefono(cursorResultados.getString("prefijotelefono"));
                    ClienteEntityRetorno.setTelefono(cursorResultados.getString("telefono"));
                }
            }
        }catch (SQLException exception){
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la informacion del cliente deseado en la base de datos";
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer un SELECT en la tabla ";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }   catch (Exception exception){
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la informacion del cliente deseado en la base de datos ";
            var mensajeTecnico = "Se ha presentado una Excepcion NO CONTROLADA tratando de hacer un SELECT en la tabla cliente ";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return ClienteEntityRetorno;

    }








    @Override
    public void modificar(UUID codigocliente, ClienteEntity entity) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE cliente SET nombre = ?, username = ?, contrasena = ?,prefijotelefono = ?, telefono = ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,codigocliente);
            sentenciaPreparada.setString(2,entity.getNombre());
            sentenciaPreparada.setString(3,entity.getUsername());
            sentenciaPreparada.setString(4,entity.getContrasena());
            sentenciaPreparada.setString(5,entity.getPrefijoTelefono());
            sentenciaPreparada.setString(6,entity.getTelefono());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de modificar la nueva informacion del cliente deseada en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la nueva informacion del cliente deseada en la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        }catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer un UPDATE del cliente deseada en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de modificar la nueva informacion del cliente deseada en la base de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

    }
}


