package co.edu.uco.backend.data.dao.entity.ubicacionprecisa.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.UbicacionPrecisaDAO;
import co.edu.uco.backend.entity.UbicacionPrecisaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class UbicacionPrecisaPostgreSQLDAO implements UbicacionPrecisaDAO {

    private final Connection connection;

    public UbicacionPrecisaPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(UbicacionPrecisaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<UbicacionPrecisaEntity> consultar(UbicacionPrecisaEntity entity) {
        return List.of();
    }

    @Override
    public UbicacionPrecisaEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(UbicacionPrecisaEntity entity) {

    }
}
