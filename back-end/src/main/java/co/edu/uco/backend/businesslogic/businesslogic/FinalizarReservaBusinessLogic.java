package co.edu.uco.backend.businesslogic.businesslogic;

import java.time.LocalDateTime;
import java.util.UUID;

public interface FinalizarReservaBusinessLogic {
    void finalizarReserva(UUID reservaId, LocalDateTime hora);
}
