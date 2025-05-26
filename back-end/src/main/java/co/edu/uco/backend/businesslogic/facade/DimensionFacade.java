package co.edu.uco.backend.businesslogic.facade;


import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.dto.DimensionDTO;

import java.util.UUID;

public interface DimensionFacade {

    void establecerDimension(UUID canchaId, UUID dimensionId, DimensionDTO dimension) throws BackEndException;
    void eliminarDimension(UUID canchaId, UUID dimensionId) throws BackEndException;
    DimensionDTO consultarDimensionPorId(UUID canchaId, UUID dimensionId) throws BackEndException;

}
