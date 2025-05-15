package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.DimensionBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.DimensionBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.DimensionFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.DimensionDTO;

import java.util.List;
import java.util.UUID;

public class DimensionFacadeImpl implements DimensionFacade {

    private DAOFactory daoFactory;
    private DimensionBusinessLogic businessLogic;

    public DimensionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new DimensionBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoDimension(DimensionDTO dto) {

    }

    @Override
    public void modificarDimension(UUID id, DimensionDTO dto) {

    }

    @Override
    public void darBajaDefinitivaDimensionExistente(UUID id) {

    }

    @Override
    public DimensionDTO consultarDimensionPorId(UUID id) {
        return null;
    }

    @Override
    public List<DimensionDTO> consultarDimensionsPorFiltro(DimensionDTO filtro) {
        return List.of();
    }
}
