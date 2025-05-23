package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionGestionCanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class OrganizacionGestionCanchaBusinessLogicImpl implements OrganizacionGestionCanchaBusinessLogic {


    public OrganizacionGestionCanchaBusinessLogicImpl(DAOFactory daoFactory) {

    }

    @Override
    public UUID registrarNuevaCancha(UUID orgId, CanchaDomain cancha) {

        return null;
    }

    @Override
    public void modificarCanchaExistente(UUID orgId, CanchaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteCanchaExistente(UUID orgId, UUID canchaId) {

    }

    @Override
    public CanchaDomain consultarCanchaPorId(UUID orgId, UUID canchaId) {
        return null;
    }

    @Override
    public List<CanchaDomain> consultarMisCanchas(UUID orgId, CanchaDomain filtro) {
        return List.of();
    }
    

    
}
