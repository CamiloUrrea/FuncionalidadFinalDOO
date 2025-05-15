package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.EstadoReservaDTO;

import java.util.List;
import java.util.UUID;

public interface EstadoReservaFacade {

    void registrarNuevoEstadoReserva(EstadoReservaDTO dto);

    void modificarEstadoReserva(UUID id, EstadoReservaDTO dto);

    void darBajaDefinitivaEstadoReservaExistente(UUID id);

    EstadoReservaDTO consultarEstadoReservaPorId(UUID id);

    List<EstadoReservaDTO> consultarEstadoReservasPorFiltro(EstadoReservaDTO filtro);

}
