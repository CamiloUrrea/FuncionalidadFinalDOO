package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.TipoCanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.TipoCanchaDomain;

import java.util.List;
import java.util.UUID;

public class TipoCanchaBusinessLogicImpl implements TipoCanchaBusinessLogic {

    @Override
    public void registrarNuevoTipoCancha(TipoCanchaDomain domain) {

    }

    @Override
    public void modificarTipoCanchaExistente(UUID id, TipoCanchaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteTipoCanchaExistente(UUID id) {

    }

    @Override
    public TipoCanchaDomain consultarTipoCanchaPorId(UUID id) {
        return null;
    }

    @Override
    public List<TipoCanchaDomain> consultarTipoCanchas(TipoCanchaDomain filtro) {
        return List.of();
    }
}
