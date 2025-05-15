package co.edu.uco.backend.data.dao.entity.ubicacionprecisa.impl.azuresql;

import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.UbicacionPrecisaDAO;
import co.edu.uco.backend.entity.UbicacionPrecisaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class UbicacionPrecisaAzureSQLDAO implements UbicacionPrecisaDAO {

    private final Connection connection;

    public UbicacionPrecisaAzureSQLDAO(Connection connection) {
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
