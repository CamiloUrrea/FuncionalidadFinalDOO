package co.edu.uco.backend.data.dao.entity.cliente.impl.azuresql;

import co.edu.uco.backend.data.dao.entity.cliente.ClienteDAO;
import co.edu.uco.backend.entity.ClienteEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ClienteAzureSQLDAO implements ClienteDAO {

    private final Connection connection;

    public ClienteAzureSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(ClienteEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<ClienteEntity> consultar(ClienteEntity entity) {
        return List.of();
    }

    @Override
    public ClienteEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(ClienteEntity entity) {

    }
}
