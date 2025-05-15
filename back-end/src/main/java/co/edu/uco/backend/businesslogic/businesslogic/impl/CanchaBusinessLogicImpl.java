package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.CanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;

import java.util.List;
import java.util.UUID;

public class CanchaBusinessLogicImpl implements CanchaBusinessLogic {

    @Override
    public void registrarNuevoCancha(CanchaDomain domain) {

    }

    @Override
    public void modificarCanchaExistente(UUID id, CanchaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteCanchaExistente(UUID id) {

    }

    @Override
    public CanchaDomain consultarCanchaPorId(UUID id) {
        return null;
    }

    @Override
    public List<CanchaDomain> consultarCanchas(CanchaDomain filtro) {
        return List.of();
    }
}
