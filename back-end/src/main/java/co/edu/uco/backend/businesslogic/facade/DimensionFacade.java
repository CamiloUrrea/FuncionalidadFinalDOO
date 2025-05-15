package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.DimensionDTO;

import java.util.List;
import java.util.UUID;

public interface DimensionFacade {

    void registrarNuevoDimension(DimensionDTO dto);

    void modificarDimension(UUID id, DimensionDTO dto);

    void darBajaDefinitivaDimensionExistente(UUID id);

    DimensionDTO consultarDimensionPorId(UUID id);

    List<DimensionDTO> consultarDimensionsPorFiltro(DimensionDTO filtro);

}
