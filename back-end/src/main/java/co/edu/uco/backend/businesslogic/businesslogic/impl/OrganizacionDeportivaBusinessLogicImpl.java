package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionDeportivaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.OrganizacionDeportivaDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class OrganizacionDeportivaBusinessLogicImpl implements OrganizacionDeportivaBusinessLogic {

    public OrganizacionDeportivaBusinessLogicImpl(DAOFactory daoFactory) {
    }

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
    public List<OrganizacionDeportivaDomain> consultarOrganizacionesDeportivas(OrganizacionDeportivaDomain filtro) {
        return List.of();
    }
}
