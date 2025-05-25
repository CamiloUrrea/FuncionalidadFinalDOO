package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.SuperficieBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.SuperficieDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class SuperficieBusinessLogicImpl implements SuperficieBusinessLogic {

    public SuperficieBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoSuperficie(SuperficieDomain superficie) {

    }

    @Override
    public void modificarSuperficieExistente(UUID id, SuperficieDomain superficie) {

    }

    @Override
    public void darBajaDefinitivamenteSuperficieExistente(UUID id) {

    }

    @Override
    public SuperficieDomain consultarSuperficiePorId(UUID id) {
        return null;
    }

    @Override
    public List<SuperficieDomain> consultarSuperficies(SuperficieDomain filtro) {
        return List.of();
    }
}
