package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoReservaDomain;

import java.util.List;
import java.util.UUID;

public interface EstadoReservaBusinessLogic {

    void registrarNuevoEstadoReserva(EstadoReservaDomain domain);

    void modificarEstadoReservaExistente(UUID id, EstadoReservaDomain domain);

    void darBajaDefinitivamenteEstadoReservaExistente(UUID id);

    EstadoReservaDomain consultarEstadoReservaPorId(UUID id);

    List<EstadoReservaDomain> consultarEstadoReservas(EstadoReservaDomain filtro);

}
