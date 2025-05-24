package co.edu.uco.backend.businesslogic.businesslogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ReservaDomain;
import java.util.List;
import java.util.UUID;

public interface ReservaBusinessLogic {

    void registrarNuevaReserva(UUID clienteID, ReservaDomain domain);

    void confirmarReserva(UUID clienteId, UUID idReserva);

    void cancelarReservaPorCliente(UUID clienteId, UUID reservaId);

    ReservaDomain consultarReservaPorCliente(UUID clienteId, UUID reservaId);

    List<ReservaDomain> listarReservasPorCliente(UUID clienteId, ReservaDomain filtro);

    void finalizarReserva(UUID clienteId, UUID reservaId);

    void cancelarReservaPorOrganizacion(UUID orgId, UUID reservaId);

    List<ReservaDomain> listarReservasPorCancha(UUID orgId, UUID canchaId);


}
