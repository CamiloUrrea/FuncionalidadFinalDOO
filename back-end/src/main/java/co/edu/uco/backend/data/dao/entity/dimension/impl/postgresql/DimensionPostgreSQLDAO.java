package co.edu.uco.backend.data.dao.entity.dimension.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.dimension.DimensionDAO;
import co.edu.uco.backend.entity.DimensionEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class DimensionPostgreSQLDAO implements DimensionDAO {

    private final Connection connection;

    public DimensionPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(DimensionEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<DimensionEntity> consultar(DimensionEntity entity) {
        return List.of();
    }

    @Override
    public DimensionEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(DimensionEntity entity) {

    }
}
