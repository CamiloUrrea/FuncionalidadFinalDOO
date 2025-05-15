package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.TipoCanchaDomain;

import java.util.List;
import java.util.UUID;

public interface TipoCanchaBusinessLogic {

    void registrarNuevoTipoCancha(TipoCanchaDomain domain);

    void modificarTipoCanchaExistente(UUID id, TipoCanchaDomain domain);

    void darBajaDefinitivamenteTipoCanchaExistente(UUID id);

    TipoCanchaDomain consultarTipoCanchaPorId(UUID id);

    List<TipoCanchaDomain> consultarTipoCanchas(TipoCanchaDomain filtro);

}
