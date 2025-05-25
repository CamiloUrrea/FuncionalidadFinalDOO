package co.edu.uco.backend.data.dao.entity.municipio.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.municipio.MunicipioDAO;
import co.edu.uco.backend.entity.MunicipioEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class MunicipioPostgreSQLDAO implements MunicipioDAO {

    private final Connection connection;

    public MunicipioPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(MunicipioEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<MunicipioEntity> consultar(MunicipioEntity entity) {
        return List.of();
    }

    @Override
    public MunicipioEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(UUID uuid, MunicipioEntity entity) {

    }
}
