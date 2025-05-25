package co.edu.uco.backend.data.dao.entity.reserva.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.reserva.ReservaDAO;
import co.edu.uco.backend.entity.ReservaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ReservaPostgreSQLDAO implements ReservaDAO {

    private final Connection connection;

    public ReservaPostgreSQLDAO(Connection connection) {
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
    public void modificar(UUID uuid, ReservaEntity entity) {

    }
}
