package co.edu.uco.backend.data.dao.entity.diasemana;

import co.edu.uco.backend.data.dao.entity.CreateDAO;
import co.edu.uco.backend.data.dao.entity.DeleteDAO;
import co.edu.uco.backend.data.dao.entity.RetrieveDAO;
import co.edu.uco.backend.data.dao.entity.UpdateDAO;
import co.edu.uco.backend.entity.DiaSemanaEntity;

import java.util.UUID;

public interface DiaSemanaDAO extends
        CreateDAO<DiaSemanaEntity>,
        RetrieveDAO<DiaSemanaEntity, UUID>,
        UpdateDAO<DiaSemanaEntity, UUID>,
        DeleteDAO<UUID> {

}
