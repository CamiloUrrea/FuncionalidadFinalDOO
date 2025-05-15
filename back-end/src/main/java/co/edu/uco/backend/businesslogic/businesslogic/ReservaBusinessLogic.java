package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.ReservaDomain;

import java.util.List;
import java.util.UUID;

public interface ReservaBusinessLogic {

    void registrarNuevoReserva(ReservaDomain domain);

    void modificarReservaExistente(UUID id, ReservaDomain domain);

    void darBajaDefinitivamenteReservaExistente(UUID id);

    ReservaDomain consultarReservaPorId(UUID id);

    List<ReservaDomain> consultarReservas(ReservaDomain filtro);

}
