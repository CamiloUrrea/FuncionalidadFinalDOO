package co.edu.uco.backend.data.dao.entity.diasemana.impl.azuresql;

import co.edu.uco.backend.data.dao.entity.diasemana.DiaSemanaDAO;
import co.edu.uco.backend.entity.DiaSemanaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class DiaSemanaAzureSQLDAO implements DiaSemanaDAO {

    private final Connection connection;

    public DiaSemanaAzureSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(DiaSemanaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<DiaSemanaEntity> consultar(DiaSemanaEntity entity) {
        return List.of();
    }

    @Override
    public DiaSemanaEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(DiaSemanaEntity entity) {

    }
}
