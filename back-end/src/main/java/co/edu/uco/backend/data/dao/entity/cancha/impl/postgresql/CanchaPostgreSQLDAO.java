package co.edu.uco.backend.data.dao.entity.cancha.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.cancha.CanchaDAO;
import co.edu.uco.backend.entity.CanchaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class CanchaPostgreSQLDAO implements CanchaDAO {

    private final Connection connection;

    public CanchaPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(CanchaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<CanchaEntity> consultar(CanchaEntity entity) {
        return List.of();
    }

    @Override
    public CanchaEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(CanchaEntity entity) {

    }
}
