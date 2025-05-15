package co.edu.uco.backend.data.dao.entity.reserva.impl.azuresql;

import co.edu.uco.backend.data.dao.entity.reserva.ReservaDAO;
import co.edu.uco.backend.entity.ReservaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ReservaAzureSQLDAO implements ReservaDAO {

    private final Connection connection;

    public ReservaAzureSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(ReservaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<ReservaEntity> consultar(ReservaEntity entity) {
        return List.of();
    }

    @Override
    public ReservaEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(ReservaEntity entity) {

    }
}
