package co.edu.uco.backend.data.dao.entity.superficie.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.superficie.SuperficieDAO;
import co.edu.uco.backend.entity.SuperficieEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class SuperficiePostgreSQLDAO implements SuperficieDAO {

    private final Connection connection;

    public SuperficiePostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(SuperficieEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<SuperficieEntity> consultar(SuperficieEntity entity) {
        return List.of();
    }

    @Override
    public SuperficieEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(SuperficieEntity entity) {

    }
}
