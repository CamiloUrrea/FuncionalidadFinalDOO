package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.UbicacionPrecisaDTO;

import java.util.UUID;

public interface UbicacionPrecisaFacade {

    void establecerUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId, UbicacionPrecisaDTO ubicacionPrecisa);
    void eliminarUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId);
    UbicacionPrecisaDTO consultarUbicacionPrecisaPorId(UUID canchaId, UUID ubicacionPrecisaId);


}
