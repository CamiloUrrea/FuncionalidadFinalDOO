package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.OrganizacionDeportivaDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizacionDeportivaFacade {

    void registrarNuevoOrganizacionDeportiva(OrganizacionDeportivaDTO dto);

    void modificarOrganizacionDeportiva(UUID id, OrganizacionDeportivaDTO dto);

    void darBajaDefinitivaOrganizacionDeportivaExistente(UUID id);

    OrganizacionDeportivaDTO consultarOrganizacionDeportivaPorId(UUID id);

    List<OrganizacionDeportivaDTO> consultarOrganizacionDeportivasPorFiltro(OrganizacionDeportivaDTO filtro);

}
