package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.TipoCanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.TipoCanchaDomain;

import java.util.List;
import java.util.UUID;

public class TipoCanchaBusinessLogicImpl implements TipoCanchaBusinessLogic {

    @Override
    public void registrarNuevoTipoCancha(TipoCanchaDomain tipoCancha) {

    }

    @Override
    public void modificarTipoCanchaExistente(UUID id, TipoCanchaDomain tipoCancha) {

    }

    @Override
    public void darBajaDefinitivamenteTipoCanchaExistente(UUID tipoCanchaId) {

    }

    @Override
    public TipoCanchaDomain consultarTipoCanchaPorId(UUID tipoCanchaId) {
        return null;
    }

    @Override
    public List<TipoCanchaDomain> consultarTipoCanchas(TipoCanchaDomain filtro) {
        return List.of();
    }
}
