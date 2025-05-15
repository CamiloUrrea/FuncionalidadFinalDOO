package co.edu.uco.backend.data.dao.entity.cliente;

import co.edu.uco.backend.data.dao.entity.CreateDAO;
import co.edu.uco.backend.data.dao.entity.DeleteDAO;
import co.edu.uco.backend.data.dao.entity.RetrieveDAO;
import co.edu.uco.backend.data.dao.entity.UpdateDAO;
import co.edu.uco.backend.entity.ClienteEntity;

import java.util.UUID;

public interface ClienteDAO extends
        CreateDAO<ClienteEntity>,
        RetrieveDAO<ClienteEntity, UUID>,
        UpdateDAO<ClienteEntity, UUID>,
        DeleteDAO<UUID> {

}
