package co.edu.uco.backend.data.dao.entity.encargado.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.encargado.EncargadoDAO;
import co.edu.uco.backend.entity.EncargadoEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class EncargadoPostgreSQLDAO implements EncargadoDAO {

    private final Connection connection;

    public EncargadoPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(EncargadoEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<EncargadoEntity> consultar(EncargadoEntity entity) {
        return List.of();
    }

    @Override
    public EncargadoEntity consultarPorId(UUID id) {
        return null;
    }



    @Override
    public void modificar(UUID uuid, EncargadoEntity entity) {

    }
}
