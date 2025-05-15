package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.CanchaDTO;

import java.util.List;
import java.util.UUID;

public interface CanchaFacade {

    void registrarNuevoCancha(CanchaDTO dto);

    void modificarCancha(UUID id, CanchaDTO dto);

    void darBajaDefinitivaCanchaExistente(UUID id);

    CanchaDTO consultarCanchaPorId(UUID id);

    List<CanchaDTO> consultarCanchasPorFiltro(CanchaDTO filtro);

}
