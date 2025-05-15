package co.edu.uco.backend.data.dao.entity.estadoverificacion.impl.azuresql;

import co.edu.uco.backend.data.dao.entity.estadoverificacion.EstadoVerificacionDAO;
import co.edu.uco.backend.entity.EstadoVerificacionEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class EstadoVerificacionAzureSQLDAO implements EstadoVerificacionDAO {

    private final Connection connection;

    public EstadoVerificacionAzureSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(EstadoVerificacionEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<EstadoVerificacionEntity> consultar(EstadoVerificacionEntity entity) {
        return List.of();
    }

    @Override
    public EstadoVerificacionEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(EstadoVerificacionEntity entity) {

    }
}
