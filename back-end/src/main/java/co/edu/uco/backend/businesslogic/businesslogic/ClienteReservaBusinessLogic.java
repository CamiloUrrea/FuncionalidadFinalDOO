package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoReservaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ReservaDomain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ClienteReservaBusinessLogic {

    void registrarNuevaReserva(UUID clienteID, ReservaDomain domain);

    void modificarReservaExistente(UUID clienteId, ReservaDomain domain);

    void darBajaDefinitivamenteReservaExistente(UUID clienteId, UUID reservaId);

    ReservaDomain consultarReservaPorId(UUID clienteId, UUID reservaId);

    List<ReservaDomain> consultarReservas(UUID clienteId, ReservaDomain filtro);



    void actualizarEstadoReserva(UUID reservaId, EstadoReservaDomain nuevoEstado);


}
