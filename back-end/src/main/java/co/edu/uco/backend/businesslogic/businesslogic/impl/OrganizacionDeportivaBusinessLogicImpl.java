package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionDeportivaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.OrganizacionDeportivaDomain;

import java.util.List;
import java.util.UUID;

public class OrganizacionDeportivaBusinessLogicImpl implements OrganizacionDeportivaBusinessLogic {

    @Override
    public void registrarNuevoOrganizacionDeportiva(OrganizacionDeportivaDomain domain) {

    }

    @Override
    public void modificarOrganizacionDeportivaExistente(UUID id, OrganizacionDeportivaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID id) {

    }

    @Override
    public OrganizacionDeportivaDomain consultarOrganizacionDeportivaPorId(UUID id) {
        return null;
    }

    @Override
    public List<OrganizacionDeportivaDomain> consultarOrganizacionDeportivas(OrganizacionDeportivaDomain filtro) {
        return List.of();
    }
}
