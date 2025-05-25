package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.ResenaDomain;

import java.util.List;
import java.util.UUID;

public interface ResenaBusinessLogic {

    void registrarNuevaResena(UUID reserva, ResenaDomain resena);

    void modificarResenaExistente(UUID reservaId, UUID resenaId, ResenaDomain resena);

    void darBajaDefinitivamenteResenaExistente(UUID reservaId, UUID resenaId);

    ResenaDomain consultarResenaPorReserva(UUID reservaId, UUID resenaId);

    List<ResenaDomain> consultarResenas(UUID reservaId, ResenaDomain filtro);

}
