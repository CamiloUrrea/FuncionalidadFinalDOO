package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.dto.UbicacionPrecisaDTO;

import java.util.UUID;

public interface UbicacionPrecisaFacade {

    void establecerUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId, UbicacionPrecisaDTO ubicacionPrecisa) throws BackEndException;
    void eliminarUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId) throws BackEndException;
    UbicacionPrecisaDTO consultarUbicacionPrecisaPorId(UUID canchaId, UUID ubicacionPrecisaId) throws BackEndException;


}
