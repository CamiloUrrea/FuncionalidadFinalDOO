package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.ResenaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ResenaDomain;

import java.util.List;
import java.util.UUID;

public class ResenaBusinessLogicImpl implements ResenaBusinessLogic {

    @Override
    public void registrarNuevoResena(ResenaDomain domain) {

    }

    @Override
    public void modificarResenaExistente(UUID id, ResenaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteResenaExistente(UUID id) {

    }

    @Override
    public ResenaDomain consultarResenaPorId(UUID id) {
        return null;
    }

    @Override
    public List<ResenaDomain> consultarResenas(ResenaDomain filtro) {
        return List.of();
    }
}
