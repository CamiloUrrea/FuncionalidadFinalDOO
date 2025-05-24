package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.CanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class CanchaBusinessLogicImpl implements CanchaBusinessLogic {


    public CanchaBusinessLogicImpl(DAOFactory daoFactory) {

    }

    @Override
    public void registrarNuevaCancha(UUID orgId, CanchaDomain cancha) {

    }

    @Override
    public void modificarCanchaExistente(UUID orgId, UUID canchaId, CanchaDomain cancha) {

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
