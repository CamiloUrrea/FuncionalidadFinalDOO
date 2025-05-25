package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoReservaDomain;

import java.util.List;
import java.util.UUID;

public interface EstadoReservaBusinessLogic {

    void registrarNuevoEstadoReserva(EstadoReservaDomain estadoReserva);

    void modificarEstadoReservaExistente(UUID estadoReservaId, EstadoReservaDomain estadoReserva);

    void darBajaDefinitivamenteEstadoReservaExistente(UUID estadoReservaId);

    EstadoReservaDomain consultarEstadoReservaPorId(UUID estadoReservaId);

    List<EstadoReservaDomain> consultarEstadoReservas(EstadoReservaDomain filtro);

}
