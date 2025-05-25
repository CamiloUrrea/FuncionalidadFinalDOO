package co.edu.uco.backend.businesslogic.facade;


import co.edu.uco.backend.dto.DimensionDTO;

import java.util.UUID;

public interface DimensionFacade {

    void establecerDimension(UUID canchaId, UUID dimensionId, DimensionDTO dimension);
    void eliminarDimension(UUID canchaId, UUID dimensionId);
    DimensionDTO consultarDimensionPorId(UUID canchaId, UUID dimensionId);

}
