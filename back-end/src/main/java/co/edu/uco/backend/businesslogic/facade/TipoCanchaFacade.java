package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.TipoCanchaDTO;

import java.util.List;
import java.util.UUID;

public interface TipoCanchaFacade {

    void registrarNuevoTipoCancha(TipoCanchaDTO dto);

    void modificarTipoCancha(UUID id, TipoCanchaDTO dto);

    void darBajaDefinitivaTipoCanchaExistente(UUID id);

    TipoCanchaDTO consultarTipoCanchaPorId(UUID id);

    List<TipoCanchaDTO> consultarTipoCanchasPorFiltro(TipoCanchaDTO filtro);

}
