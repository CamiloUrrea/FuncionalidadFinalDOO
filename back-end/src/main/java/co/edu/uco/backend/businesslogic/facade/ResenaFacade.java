package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.ResenaDTO;

import java.util.List;
import java.util.UUID;

public interface ResenaFacade {

    void registrarNuevoResena(ResenaDTO dto);

    void modificarResena(UUID id, ResenaDTO dto);

    void darBajaDefinitivaResenaExistente(UUID id);

    ResenaDTO consultarResenaPorId(UUID id);

    List<ResenaDTO> consultarResenasPorFiltro(ResenaDTO filtro);

}
