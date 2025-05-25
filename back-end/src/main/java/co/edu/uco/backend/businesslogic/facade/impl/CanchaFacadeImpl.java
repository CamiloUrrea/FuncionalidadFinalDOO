package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.CanchaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.CanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.CanchaFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.CanchaDTO;

import java.util.List;
import java.util.UUID;

public class CanchaFacadeImpl implements CanchaFacade {

    private DAOFactory daoFactory;
    private CanchaBusinessLogic canchaBusinessLogic;

    public CanchaFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
        canchaBusinessLogic = new CanchaBusinessLogicImpl(daoFactory);
    }


    @Override
    public void registrarNuevaCancha(UUID orgId, CanchaDTO cancha)  {

    }

    @Override
    public void modificarCanchaExistente(UUID orgId, UUID canchaId, CanchaDTO cancha)  {

    }

    @Override
    public void darBajaDefinitivamenteCanchaExistente(UUID orgId, UUID canchaId)   {

    }

    @Override
    public CanchaDTO consultarCanchaPorId(UUID orgId, UUID canchaId) {
        return null;
    }

    @Override
    public List<CanchaDTO> consultarMisCanchas(UUID orgId, CanchaDTO filtro)   {
        return List.of();
    }
}
