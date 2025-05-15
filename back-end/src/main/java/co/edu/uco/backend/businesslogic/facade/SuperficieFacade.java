package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.SuperficieDTO;

import java.util.List;
import java.util.UUID;

public interface SuperficieFacade {

    void registrarNuevoSuperficie(SuperficieDTO dto);

    void modificarSuperficie(UUID id, SuperficieDTO dto);

    void darBajaDefinitivaSuperficieExistente(UUID id);

    SuperficieDTO consultarSuperficiePorId(UUID id);

    List<SuperficieDTO> consultarSuperficiesPorFiltro(SuperficieDTO filtro);

}
