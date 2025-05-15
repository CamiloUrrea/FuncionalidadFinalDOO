package co.edu.uco.backend.data.dao.entity.resena.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.resena.ResenaDAO;
import co.edu.uco.backend.entity.ResenaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ResenaPostgreSQLDAO implements ResenaDAO {

    private final Connection connection;

    public ResenaPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(ResenaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<ResenaEntity> consultar(ResenaEntity entity) {
        return List.of();
    }

    @Override
    public ResenaEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(ResenaEntity entity) {

    }
}
