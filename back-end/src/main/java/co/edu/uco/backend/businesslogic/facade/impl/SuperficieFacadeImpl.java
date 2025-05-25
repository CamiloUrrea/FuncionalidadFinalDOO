package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.SuperficieBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.SuperficieBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.SuperficieFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.SuperficieDTO;

import java.util.List;
import java.util.UUID;

public class SuperficieFacadeImpl implements SuperficieFacade {

    private DAOFactory daoFactory;
    private SuperficieBusinessLogic superficieBusinessLogic;

    public SuperficieFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
        superficieBusinessLogic = new SuperficieBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoSuperficie(SuperficieDTO superficie) {

    }

    @Override
    public void modificarSuperficieExistente(UUID id, SuperficieDTO superficie) {

    }

    @Override
    public void darBajaDefinitivamenteSuperficieExistente(UUID id) {

    }

    @Override
    public SuperficieDTO consultarSuperficiePorId(UUID id) {
        return null;
    }

    @Override
    public List<SuperficieDTO> consultarSuperficies(SuperficieDTO filtro) {
        return List.of();
    }
}
