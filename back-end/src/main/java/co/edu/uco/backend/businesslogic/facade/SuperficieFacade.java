package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.SuperficieDTO;

import java.util.List;
import java.util.UUID;

public interface SuperficieFacade {

    void registrarNuevoSuperficie(SuperficieDTO superficie);

    void modificarSuperficieExistente(UUID id, SuperficieDTO superficie);

    void darBajaDefinitivamenteSuperficieExistente(UUID id);

    SuperficieDTO consultarSuperficiePorId(UUID id);

    List<SuperficieDTO> consultarSuperficies(SuperficieDTO filtro);

}
