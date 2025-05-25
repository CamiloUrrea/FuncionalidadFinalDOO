package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.TipoCanchaDomain;

import java.util.List;
import java.util.UUID;

public interface TipoCanchaBusinessLogic {

    void registrarNuevoTipoCancha(TipoCanchaDomain tipoCancha);

    void modificarTipoCanchaExistente(UUID id, TipoCanchaDomain tipoCancha);

    void darBajaDefinitivamenteTipoCanchaExistente(UUID tipoCanchaId);

    TipoCanchaDomain consultarTipoCanchaPorId(UUID tipoCanchaId);

    List<TipoCanchaDomain> consultarTipoCanchas(TipoCanchaDomain filtro);

}
