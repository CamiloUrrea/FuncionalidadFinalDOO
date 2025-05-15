package co.edu.uco.backend.data.dao.entity.factura.impl.azuresql;

import co.edu.uco.backend.data.dao.entity.factura.FacturaDAO;
import co.edu.uco.backend.entity.FacturaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class FacturaAzureSQLDAO implements FacturaDAO {

    private final Connection connection;

    public FacturaAzureSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(FacturaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<FacturaEntity> consultar(FacturaEntity entity) {
        return List.of();
    }

    @Override
    public FacturaEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(FacturaEntity entity) {

    }
}
