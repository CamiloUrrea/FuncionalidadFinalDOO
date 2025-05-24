package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.UbicacionPrecisaDomain;

import java.util.UUID;

public interface UbicacionPrecisaBusinessLogic {

    void establecerUbicacion(UUID canchaId, UbicacionPrecisaDomain ubicacion);
    void eliminarUbicacion(UUID canchaId);
    UbicacionPrecisaDomain consultarUbicacionPorCancha(UUID canchaId);

}
