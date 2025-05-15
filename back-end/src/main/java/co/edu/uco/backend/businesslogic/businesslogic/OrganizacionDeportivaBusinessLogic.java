package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.OrganizacionDeportivaDomain;

import java.util.List;
import java.util.UUID;

public interface OrganizacionDeportivaBusinessLogic {

    void registrarNuevoOrganizacionDeportiva(OrganizacionDeportivaDomain domain);

    void modificarOrganizacionDeportivaExistente(UUID id, OrganizacionDeportivaDomain domain);

    void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID id);

    OrganizacionDeportivaDomain consultarOrganizacionDeportivaPorId(UUID id);

    List<OrganizacionDeportivaDomain> consultarOrganizacionDeportivas(OrganizacionDeportivaDomain filtro);

}
