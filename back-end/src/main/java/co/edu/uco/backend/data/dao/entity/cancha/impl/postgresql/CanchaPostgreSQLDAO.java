package co.edu.uco.backend.data.dao.entity.cancha.impl.postgresql;
import co.edu.uco.backend.crosscutting.Exceptions.BackEndException;
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
    public void create(CanchaEntity entity){
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO cancha(codigocancha, nombre, dimensiones, superficie, iluminacion, cubierta, costoporhora, codigotipocancha, codigoorganizacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try(var sentenciaPreparada = connection.prepareStatement(sentenciaSQL.toString())){
        }catch (SQLException e){

        }
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
    public void modificar(CanchaEntity entity) {

    }

    @Override
    public void crear(CanchaEntity entity) throws BackEndException {

    }
}





