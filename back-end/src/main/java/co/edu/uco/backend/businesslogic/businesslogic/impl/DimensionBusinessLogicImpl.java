package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.DimensionBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.DimensionDomain;

import java.util.List;
import java.util.UUID;

public class DimensionBusinessLogicImpl implements DimensionBusinessLogic {

    @Override
    public void registrarNuevoDimension(DimensionDomain domain) {

    }

    @Override
    public void modificarDimensionExistente(UUID id, DimensionDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteDimensionExistente(UUID id) {

    }

    @Override
    public DimensionDomain consultarDimensionPorId(UUID id) {
        return null;
    }

    @Override
    public List<DimensionDomain> consultarDimensions(DimensionDomain filtro) {
        return List.of();
    }
}
