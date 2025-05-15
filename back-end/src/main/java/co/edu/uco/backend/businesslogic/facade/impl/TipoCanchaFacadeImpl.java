package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.TipoCanchaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.TipoCanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.TipoCanchaFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.TipoCanchaDTO;

import java.util.List;
import java.util.UUID;

public class TipoCanchaFacadeImpl implements TipoCanchaFacade {

    private DAOFactory daoFactory;
    private TipoCanchaBusinessLogic businessLogic;

    public TipoCanchaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new TipoCanchaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoTipoCancha(TipoCanchaDTO dto) {

    }

    @Override
    public void modificarTipoCancha(UUID id, TipoCanchaDTO dto) {

    }

    @Override
    public void darBajaDefinitivaTipoCanchaExistente(UUID id) {

    }

    @Override
    public TipoCanchaDTO consultarTipoCanchaPorId(UUID id) {
        return null;
    }

    @Override
    public List<TipoCanchaDTO> consultarTipoCanchasPorFiltro(TipoCanchaDTO filtro) {
        return List.of();
    }
}
