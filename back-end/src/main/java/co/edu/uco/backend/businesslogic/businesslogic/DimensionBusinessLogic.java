package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.DimensionDomain;

import java.util.List;
import java.util.UUID;

public interface DimensionBusinessLogic {

    void registrarNuevoDimension(DimensionDomain domain);

    void modificarDimensionExistente(UUID id, DimensionDomain domain);

    void darBajaDefinitivamenteDimensionExistente(UUID id);

    DimensionDomain consultarDimensionPorId(UUID id);

    List<DimensionDomain> consultarDimensions(DimensionDomain filtro);

}
