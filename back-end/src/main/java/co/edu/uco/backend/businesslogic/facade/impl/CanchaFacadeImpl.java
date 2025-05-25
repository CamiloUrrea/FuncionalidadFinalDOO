package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
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
    public void registrarNuevaCancha(UUID orgId, CanchaDTO cancha) throws BackEndException {
        try {
            daoFactory.iniciarTransaccion();

            CanchaDomain canchaDomain = null; //TODO: magia de convertir de DTO a Domain
            canchaBusinessLogic.registrarNuevaCancha(orgId, canchaDomain);

            daoFactory.confirmarTransaccion();
        } catch (BackEndException exception) {
            daoFactory.cancelarTransaccion();
        } catch (Exception exception){
            daoFactory.cancelarTransaccion();
        }

    }

    @Override
    public void modificarCanchaExistente(UUID orgId, UUID canchaId, CanchaDTO cancha)  {

    }

    @Override
    public void darBajaDefinitivamenteCanchaExistente(UUID orgId, UUID canchaId)   {

    }

    @Override
    public CanchaDTO consultarCanchaPorOrganizacion(UUID orgId, UUID canchaId) throws BackEndException {
        return null;
    }

    @Override
    public List<CanchaDTO> listarCanchasPorOrganizacion(UUID orgId, CanchaDTO filtro) throws BackEndException {
        return List.of();
    }

    @Override
    public CanchaDTO consultarCanchaPorId(UUID canchaId) throws BackEndException {
        return null;
    }

    @Override
    public List<CanchaDTO> consultarTodasCanchas(CanchaDTO filtro) throws BackEndException {
        return List.of();
    }


}
