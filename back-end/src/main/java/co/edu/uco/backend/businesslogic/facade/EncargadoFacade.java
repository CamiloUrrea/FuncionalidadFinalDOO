package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.EncargadoDTO;

import java.util.List;
import java.util.UUID;

public interface EncargadoFacade {

    void registrarNuevoEncargado(EncargadoDTO dto);

    void modificarEncargado(UUID id, EncargadoDTO dto);

    void darBajaDefinitivaEncargadoExistente(UUID id);

    EncargadoDTO consultarEncargadoPorId(UUID id);

    List<EncargadoDTO> consultarEncargadosPorFiltro(EncargadoDTO filtro);

}
