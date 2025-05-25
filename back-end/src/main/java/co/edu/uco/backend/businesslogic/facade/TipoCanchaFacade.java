package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.TipoCanchaDTO;

import java.util.List;
import java.util.UUID;

public interface TipoCanchaFacade {

    void registrarNuevoTipoCancha(TipoCanchaDTO tipoCancha);

    void modificarTipoCanchaExistente(UUID id, TipoCanchaDTO tipoCancha);

    void darBajaDefinitivamenteTipoCanchaExistente(UUID tipoCanchaId);

    TipoCanchaDTO consultarTipoCanchaPorId(UUID tipoCanchaId);

    List<TipoCanchaDTO> consultarTipoCanchas(TipoCanchaDTO filtro);

}
