package co.edu.uco.backend.data.dao.entity.organizaciondeportiva;

import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.entity.CreateDAO;
import co.edu.uco.backend.data.dao.entity.DeleteDAO;
import co.edu.uco.backend.data.dao.entity.RetrieveDAO;
import co.edu.uco.backend.data.dao.entity.UpdateDAO;
import co.edu.uco.backend.entity.OrganizacionDeportivaEntity;

import java.util.List;
import java.util.UUID;

public interface OrganizacionDeportivaDAO extends
        CreateDAO<OrganizacionDeportivaEntity>,
        RetrieveDAO<OrganizacionDeportivaEntity, UUID>,
        UpdateDAO<OrganizacionDeportivaEntity, UUID>,
        DeleteDAO<UUID> {

    List<OrganizacionDeportivaEntity> listAll() throws BackEndException;
}
