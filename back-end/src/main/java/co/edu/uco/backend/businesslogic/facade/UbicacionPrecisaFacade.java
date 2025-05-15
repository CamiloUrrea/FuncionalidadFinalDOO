package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.UbicacionPrecisaDTO;

import java.util.List;
import java.util.UUID;

public interface UbicacionPrecisaFacade {

    void registrarNuevoUbicacionPrecisa(UbicacionPrecisaDTO dto);

    void modificarUbicacionPrecisa(UUID id, UbicacionPrecisaDTO dto);

    void darBajaDefinitivaUbicacionPrecisaExistente(UUID id);

    UbicacionPrecisaDTO consultarUbicacionPrecisaPorId(UUID id);

    List<UbicacionPrecisaDTO> consultarUbicacionPrecisasPorFiltro(UbicacionPrecisaDTO filtro);

}
