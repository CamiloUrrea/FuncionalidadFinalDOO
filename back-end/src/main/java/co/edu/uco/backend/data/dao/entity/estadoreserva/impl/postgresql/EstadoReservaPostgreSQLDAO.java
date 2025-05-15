package co.edu.uco.backend.data.dao.entity.estadoreserva.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.estadoreserva.EstadoReservaDAO;
import co.edu.uco.backend.entity.EstadoReservaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class EstadoReservaPostgreSQLDAO implements EstadoReservaDAO {

    private final Connection connection;

    public EstadoReservaPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(EstadoReservaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<EstadoReservaEntity> consultar(EstadoReservaEntity entity) {
        return List.of();
    }

    @Override
    public EstadoReservaEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(EstadoReservaEntity entity) {

    }
}
