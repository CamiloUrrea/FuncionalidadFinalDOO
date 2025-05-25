package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.DimensionBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.DimensionDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.UUID;

public class DimensionBusinessLogicImpl implements DimensionBusinessLogic {


    public DimensionBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void establecerDimension(UUID canchaId, UUID dimensionId, DimensionDomain dimension) {

    }

    @Override
    public void eliminarDimension(UUID canchaId, UUID dimensionId) {

    }

    @Override
    public DimensionDomain consultarDimensionPorId(UUID canchaId, UUID dimensionId) {
        return null;
    }


}
