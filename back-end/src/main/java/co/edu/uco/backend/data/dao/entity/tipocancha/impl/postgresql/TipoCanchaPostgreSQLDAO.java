package co.edu.uco.backend.data.dao.entity.tipocancha.impl.postgresql;

import co.edu.uco.backend.data.dao.entity.tipocancha.TipoCanchaDAO;
import co.edu.uco.backend.entity.TipoCanchaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class TipoCanchaPostgreSQLDAO implements TipoCanchaDAO {

    private final Connection connection;

    public TipoCanchaPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(TipoCanchaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<TipoCanchaEntity> consultar(TipoCanchaEntity entity) {
        return List.of();
    }

    @Override
    public TipoCanchaEntity consultarPorId(UUID id) {
        return null;
    }


    @Override
    public void modificar(UUID uuid, TipoCanchaEntity entity) {

    }
}
