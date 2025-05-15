package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.SuperficieBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.SuperficieBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.SuperficieFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.SuperficieDTO;

import java.util.List;
import java.util.UUID;

public class SuperficieFacadeImpl implements SuperficieFacade {

    private DAOFactory daoFactory;
    private SuperficieBusinessLogic businessLogic;

    public SuperficieFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new SuperficieBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoSuperficie(SuperficieDTO dto) {

    }

    @Override
    public void modificarSuperficie(UUID id, SuperficieDTO dto) {

    }

    @Override
    public void darBajaDefinitivaSuperficieExistente(UUID id) {

    }

    @Override
    public SuperficieDTO consultarSuperficiePorId(UUID id) {
        return null;
    }

    @Override
    public List<SuperficieDTO> consultarSuperficiesPorFiltro(SuperficieDTO filtro) {
        return List.of();
    }
}
