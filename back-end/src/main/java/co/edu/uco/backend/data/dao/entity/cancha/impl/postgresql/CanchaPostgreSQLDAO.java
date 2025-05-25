package co.edu.uco.backend.data.dao.entity.cancha.impl.postgresql;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.DataBackEndException;
import co.edu.uco.backend.data.dao.entity.cancha.CanchaDAO;
import co.edu.uco.backend.entity.CanchaEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CanchaPostgreSQLDAO implements CanchaDAO {

    private final Connection connection;

    public CanchaPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void eliminar(UUID uuid) {

    }

    @Override
    public List<CanchaEntity> consultar(CanchaEntity filtro) {
        return List.of();
    }

    @Override
    public CanchaEntity consultarPorId(UUID uuid) {
        return null;
    }


    @Override
    public void crear(CanchaEntity entity) throws BackEndException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO cancha(codigocancha, nombre, dimensiones, superficie, iluminacion, cubierta, costoporhora, codigotipocancha, codigoorganizacion)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,entity.getId());
            sentenciaPreparada.setString(2,entity.getNombreCancha());
            sentenciaPreparada.setObject(3,entity.getDimensiones());
            sentenciaPreparada.setObject(4,entity.getSuperficie());
            sentenciaPreparada.setBoolean(5,entity.isIluminacion());
            sentenciaPreparada.setBoolean(6,entity.isCubierta());
            sentenciaPreparada.setDouble(7,entity.getCostoHora());
            sentenciaPreparada.setObject(8,entity.getTipo());
            sentenciaPreparada.setObject(9,entity.getOrganizacion());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
        var mensajeTecnico = "Se presentó una SQLException tratando de registrar la nueva informacion de la cancha en la base de datos, para más detalles revise el log de errores";
        var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva informacion de la cancha en la fuente de datos";

        throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        }catch (Exception exception) {
        var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ingresar la nueva infromacion de la cancha en la base de datos, para más detalles revise el log de errores";
        var mensajeUsuario = "Se ha presentado un problema inesperado tratando de ingresar la nueva informacion de la cancha en la base de datos    ";

        throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }


    @Override
    public void modificar(UUID uuid, CanchaEntity entity) throws BackEndException{
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE cancha SET nombre = ?, dimensiones = ?, superficie = ?, iluminacion = ?, cubierta = ?, costoporhora = ?, codigotipocancha = ?, codigoorganizacion = ? WHERE codigocancha = ?)");
        try (var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
            sentenciaPreparada.setObject(1,entity.getId());
            sentenciaPreparada.setString(2,entity.getNombreCancha());
            sentenciaPreparada.setObject(3,entity.getDimensiones());
            sentenciaPreparada.setObject(4,entity.getSuperficie());
            sentenciaPreparada.setBoolean(5,entity.isIluminacion());
            sentenciaPreparada.setBoolean(6,entity.isCubierta());
            sentenciaPreparada.setDouble(7,entity.getCostoHora());
            sentenciaPreparada.setObject(8,entity.getTipo());
            sentenciaPreparada.setObject(9,entity.getOrganizacion());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de modificar la nueva informacion de la cancha deseada en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la nueva informacion de la cancha deseada en la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        }catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer un UPDATE de la cancha deseada en la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de modificar la nueva informacion de la cancha deseada en la base de datos    ";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}





