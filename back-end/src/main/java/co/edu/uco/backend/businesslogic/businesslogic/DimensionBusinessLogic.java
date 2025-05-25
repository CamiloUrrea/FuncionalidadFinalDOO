package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.DimensionDomain;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;

import java.util.UUID;

public interface DimensionBusinessLogic {

    void establecerDimension(UUID canchaId, UUID dimensionId, DimensionDomain dimension);
    void eliminarDimension(UUID canchaId, UUID dimensionId) throws BackEndException;
    DimensionDomain consultarDimensionPorId(UUID canchaId, UUID dimensionId) throws BackEndException;


}
