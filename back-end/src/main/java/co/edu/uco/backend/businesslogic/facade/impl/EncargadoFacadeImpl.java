package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.EncargadoBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.EncargadoBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.EncargadoFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.EncargadoDTO;

import java.util.List;
import java.util.UUID;

public class EncargadoFacadeImpl implements EncargadoFacade {

    private DAOFactory daoFactory;
    private EncargadoBusinessLogic businessLogic;

    public EncargadoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new EncargadoBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoEncargado(EncargadoDTO dto) {

    }

    @Override
    public void modificarEncargado(UUID id, EncargadoDTO dto) {

    }

    @Override
    public void darBajaDefinitivaEncargadoExistente(UUID id) {

    }

    @Override
    public EncargadoDTO consultarEncargadoPorId(UUID id) {
        return null;
    }

    @Override
    public List<EncargadoDTO> consultarEncargadosPorFiltro(EncargadoDTO filtro) {
        return List.of();
    }
}
