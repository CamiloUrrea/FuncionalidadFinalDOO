package co.edu.uco.backend.data.dao.entity.organizaciondeportiva.impl.azuresql;

import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.OrganizacionDeportivaDAO;
import co.edu.uco.backend.entity.OrganizacionDeportivaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class OrganizacionDeportivaAzureSQLDAO implements OrganizacionDeportivaDAO {

    private Connection connection;

    public OrganizacionDeportivaAzureSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(OrganizacionDeportivaEntity entity) {

    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<OrganizacionDeportivaEntity> consultar(OrganizacionDeportivaEntity entity) {
        return List.of();
    }

    @Override
    public OrganizacionDeportivaEntity consultarPorId(UUID id) {
        return null;
    }

    @Override
    public void modificar(OrganizacionDeportivaEntity entity) {

    }
}
