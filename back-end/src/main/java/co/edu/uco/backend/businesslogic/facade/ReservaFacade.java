package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.ReservaDTO;

import java.util.List;
import java.util.UUID;

public interface ReservaFacade {

    void registrarNuevoReserva(ReservaDTO dto);

    void modificarReserva(UUID id, ReservaDTO dto);

    void darBajaDefinitivaReservaExistente(UUID id);

    ReservaDTO consultarReservaPorId(UUID id);

    List<ReservaDTO> consultarReservasPorFiltro(ReservaDTO filtro);

}
