package co.edu.uco.backend.data.dao.entity.cliente.impl.postgresql;

import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.DataBackEndException;
import co.edu.uco.backend.data.dao.entity.cliente.ClienteDAO;
import co.edu.uco.backend.entity.ClienteEntity;
import co.edu.uco.backend.entity.EncargadoEntity;

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
        sentenciaSQL.append("INSERT INTO encargado(encargadoId, nombre, usuario, contrasena, prefijo, telefono)" +
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
    public void eliminar(UUID clienteId) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM cliente WHERE clieenteid = ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,clienteId);

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
    public ClienteEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(UUID clienteId, ClienteEntity entity) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE encargado SET nombre = ?, usuario = ?, contrasena = ?,prefijo = ?, telefono = ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,clienteId);
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
