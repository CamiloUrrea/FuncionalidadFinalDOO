package co.edu.uco.backend.data.dao.entity.organizaciondeportiva;

import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.entity.CreateDAO;
import co.edu.uco.backend.data.dao.entity.DeleteDAO;
import co.edu.uco.backend.data.dao.entity.RetrieveDAO;
import co.edu.uco.backend.data.dao.entity.UpdateDAO;
import co.edu.uco.backend.entity.OrganizacionDeportivaEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizacionDeportivaDAO extends
        CreateDAO<OrganizacionDeportivaEntity>,
        RetrieveDAO<OrganizacionDeportivaEntity, UUID>,
        UpdateDAO<OrganizacionDeportivaEntity, UUID>,
        DeleteDAO<UUID> {

    List<OrganizacionDeportivaEntity> listAll() throws BackEndException;

    /**
     * Verifica si ya existe una organización con el mismo username.
     * @param username El nombre de usuario a chequear.
     * @return true si existe, false si no.
     * @throws BackEndException Si ocurre error en la consulta.
     */
    boolean existsByUsername(String username) throws BackEndException;

    /**
     * Verifica si ya existe una organización con el mismo RUT.
     * @param rut El RUT (documentoExistencia) a chequear.
     * @return true si existe, false si no.
     * @throws BackEndException Si ocurre error en la consulta.
     */
    boolean existsByRut(String rut) throws BackEndException;

    boolean existsByCorreo(String correoAdministrativo) throws BackEndException;

    Optional<OrganizacionDeportivaEntity> consultarPorUsername(String username) throws BackEndException;
}
