package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.OrganizacionDeportivaDomain;

import java.util.List;
import java.util.UUID;

public interface OrganizacionDeportivaBusinessLogic extends UsuarioBusinessLogic {

    void registrarNuevaOrganizacionDeportiva(OrganizacionDeportivaDomain organizacionDeportiva);

    void modificarOrganizacionDeportivaExistente(UUID orgId, OrganizacionDeportivaDomain organizacionDeportiva);

    void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID orgId);

    OrganizacionDeportivaDomain consultarOrganizacionDeportivaPorId(UUID orgId);

    List<OrganizacionDeportivaDomain> consultarOrganizacionesDeportivas(OrganizacionDeportivaDomain filtro);

    void aceptarOrganizacion(UUID orgId);

    void rechazarOrganizacion(UUID orgId);


}
