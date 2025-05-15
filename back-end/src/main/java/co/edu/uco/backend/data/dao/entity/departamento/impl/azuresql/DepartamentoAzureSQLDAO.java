package co.edu.uco.backend.data.dao.entity.departamento.impl.azuresql;

import co.edu.uco.backend.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.backend.entity.DepartamentoEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class DepartamentoAzureSQLDAO implements DepartamentoDAO {

    private final Connection connection;

    public DepartamentoAzureSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(DepartamentoEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<DepartamentoEntity> consultar(DepartamentoEntity entity) {
        return List.of();
    }

    @Override
    public DepartamentoEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(DepartamentoEntity entity) {

    }
}
