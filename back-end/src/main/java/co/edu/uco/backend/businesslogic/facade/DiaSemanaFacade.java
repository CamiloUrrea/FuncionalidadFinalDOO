package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.DiaSemanaDTO;

import java.util.List;
import java.util.UUID;

public interface DiaSemanaFacade {

    void registrarNuevoDiaSemana(DiaSemanaDTO dto);

    void modificarDiaSemana(UUID id, DiaSemanaDTO dto);

    void darBajaDefinitivaDiaSemanaExistente(UUID id);

    DiaSemanaDTO consultarDiaSemanaPorId(UUID id);

    List<DiaSemanaDTO> consultarDiaSemanasPorFiltro(DiaSemanaDTO filtro);

}
