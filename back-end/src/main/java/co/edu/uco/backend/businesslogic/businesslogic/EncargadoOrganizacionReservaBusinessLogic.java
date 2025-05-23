package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.ReservaDomain;

import java.util.List;
import java.util.UUID;

public interface EncargadoOrganizacionReservaBusinessLogic {
    boolean cancelarReservaMiCancha(UUID reservaId);
    List<ReservaDomain> consultarReservasMiCancha(UUID canchaId);
}
