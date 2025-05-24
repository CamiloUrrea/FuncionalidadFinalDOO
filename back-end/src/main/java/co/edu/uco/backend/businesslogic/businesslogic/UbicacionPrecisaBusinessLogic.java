package co.edu.uco.backend.businesslogic.businesslogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UbicacionPrecisaDomain;

import java.util.UUID;

public interface UbicacionPrecisaBusinessLogic {

    void establecerUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId, UbicacionPrecisaDomain ubicacionPrecisa);
    void eliminarUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId);
    UbicacionPrecisaDomain consultarUbicacionPrecisaPorId(UUID canchaId, UUID ubicacionPrecisaId);
    UbicacionPrecisaDomain consultarUbicacionPrecisaPorCancha(UUID canchaId, UbicacionPrecisaDomain filtro);
}
