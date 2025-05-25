package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.DimensionBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.DimensionBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.DimensionFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.DimensionDTO;


import java.util.UUID;

public class DimensionFacadeImpl implements DimensionFacade {

    private DAOFactory daoFactory;
    private DimensionBusinessLogic businessLogic;

    public DimensionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new DimensionBusinessLogicImpl(daoFactory);
    }


    @Override
    public void establecerDimension(UUID canchaId, UUID dimensionId, DimensionDTO dimension) {

    }

    @Override
    public void eliminarDimension(UUID canchaId, UUID dimensionId) {

    }

    @Override
    public DimensionDTO consultarDimensionPorId(UUID canchaId, UUID dimensionId) {
        return null;
    }


}
