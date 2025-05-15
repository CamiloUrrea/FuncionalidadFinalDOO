package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.ResenaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.ResenaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.ResenaFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.ResenaDTO;

import java.util.List;
import java.util.UUID;

public class ResenaFacadeImpl implements ResenaFacade {

    private DAOFactory daoFactory;
    private ResenaBusinessLogic businessLogic;

    public ResenaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new ResenaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoResena(ResenaDTO dto) {

    }

    @Override
    public void modificarResena(UUID id, ResenaDTO dto) {

    }

    @Override
    public void darBajaDefinitivaResenaExistente(UUID id) {

    }

    @Override
    public ResenaDTO consultarResenaPorId(UUID id) {
        return null;
    }

    @Override
    public List<ResenaDTO> consultarResenasPorFiltro(ResenaDTO filtro) {
        return List.of();
    }
}
