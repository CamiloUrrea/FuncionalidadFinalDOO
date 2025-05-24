package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.DimensionDomain;

import java.util.UUID;

public interface DimensionBusinessLogic {

    void establecerDimension(UUID canchaId, DimensionDomain dimension);
    void eliminarDimension(UUID canchaId) ;
    DimensionDomain consultarDimensionPorCancha(UUID canchaId);

}
