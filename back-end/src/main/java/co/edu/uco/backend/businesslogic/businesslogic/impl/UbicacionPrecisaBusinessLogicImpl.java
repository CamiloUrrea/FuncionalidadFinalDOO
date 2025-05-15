package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.UbicacionPrecisaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UbicacionPrecisaDomain;

import java.util.List;
import java.util.UUID;

public class UbicacionPrecisaBusinessLogicImpl implements UbicacionPrecisaBusinessLogic {

    @Override
    public void registrarNuevoUbicacionPrecisa(UbicacionPrecisaDomain domain) {

    }

    @Override
    public void modificarUbicacionPrecisaExistente(UUID id, UbicacionPrecisaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteUbicacionPrecisaExistente(UUID id) {

    }

    @Override
    public UbicacionPrecisaDomain consultarUbicacionPrecisaPorId(UUID id) {
        return null;
    }

    @Override
    public List<UbicacionPrecisaDomain> consultarUbicacionPrecisas(UbicacionPrecisaDomain filtro) {
        return List.of();
    }
}
