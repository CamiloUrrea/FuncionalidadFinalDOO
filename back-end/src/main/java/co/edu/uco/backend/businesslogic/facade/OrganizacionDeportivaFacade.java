package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.OrganizacionDeportivaDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizacionDeportivaFacade extends UsuarioFacade {

    void registrarNuevaOrganizacionDeportiva(OrganizacionDeportivaDTO organizacionDeportiva);

    void modificarOrganizacionDeportivaExistente(UUID orgId, OrganizacionDeportivaDTO organizacionDeportiva);

    void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID orgId);

    OrganizacionDeportivaDTO consultarOrganizacionDeportivaPorId(UUID orgId);

    List<OrganizacionDeportivaDTO> consultarOrganizacionesDeportivas(OrganizacionDeportivaDTO filtro);

    void aceptarOrganizacion(UUID orgId);

    void rechazarOrganizacion(UUID orgId);

}
