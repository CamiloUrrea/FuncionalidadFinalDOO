package co.edu.uco.backend.data.dao.entity.horariodisponible.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.horariodisponible.HorarioDisponibleDAO;
import co.edu.uco.backend.entity.HorarioDisponibleEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class HorarioDisponiblePostgreSQLDAO implements HorarioDisponibleDAO {

    private final Connection connection;

    public HorarioDisponiblePostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(HorarioDisponibleEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<HorarioDisponibleEntity> consultar(HorarioDisponibleEntity entity) {
        return List.of();
    }

    @Override
    public HorarioDisponibleEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(HorarioDisponibleEntity entity) {

    }
}
