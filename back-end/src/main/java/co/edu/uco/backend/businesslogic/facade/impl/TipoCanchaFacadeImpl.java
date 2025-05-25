package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.TipoCanchaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.TipoCanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.TipoCanchaFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.TipoCanchaDTO;

import java.util.List;
import java.util.UUID;

public class TipoCanchaFacadeImpl implements TipoCanchaFacade {

    private DAOFactory daoFactory;
    private TipoCanchaBusinessLogic businessLogic;

    public TipoCanchaFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new TipoCanchaBusinessLogicImpl(daoFactory);
    }


    @Override
    public void registrarNuevoTipoCancha(TipoCanchaDTO tipoCancha) {

    }

    @Override
    public void modificarTipoCanchaExistente(UUID id, TipoCanchaDTO tipoCancha) {

    }

    @Override
    public void darBajaDefinitivamenteTipoCanchaExistente(UUID tipoCanchaId) {

    }

    @Override
    public TipoCanchaDTO consultarTipoCanchaPorId(UUID tipoCanchaId) {
        return null;
    }

    @Override
    public List<TipoCanchaDTO> consultarTipoCanchas(TipoCanchaDTO filtro) {
        return List.of();
    }
}
