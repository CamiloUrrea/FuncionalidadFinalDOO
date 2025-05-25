package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.DimensionBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.DimensionDomain;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.entity.DimensionEntity;

import java.util.UUID;

public class DimensionBusinessLogicImpl implements DimensionBusinessLogic {

    private DAOFactory factory;
    public DimensionBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void establecerDimension(UUID canchaId, UUID dimensionId, DimensionDomain dimension) {
        //TODO: Mapear con upsert y validar cancha
    }

    @Override
    public void eliminarDimension(UUID canchaId, UUID dimensionId) throws BackEndException {
        DimensionEntity dimensionEntity = null;
        //TODO: Validar cancha
        factory.getDimensionDAO().eliminar(dimensionId);

    }

    @Override
    public DimensionDomain consultarDimensionPorId(UUID canchaId, UUID dimensionId) throws BackEndException {
        DimensionEntity dimensionEntity = null;
        //TODO: mapear de Entity -> Domain y validar cancha
        factory.getDimensionDAO().consultarPorId(dimensionId);
        return null;
    }


}
