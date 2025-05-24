package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.ResenaDomain;

import java.util.List;
import java.util.UUID;

public interface ResenaBusinessLogic {

    void registrarNuevoResena(UUID reserva, ResenaDomain resena);

    void modificarResenaExistente(UUID reservaId, UUID resenaId, ResenaDomain resena);

    void darBajaDefinitivamenteResenaExistente(UUID reservaId, UUID resenaId);

    ResenaDomain consultarResenaPorReserva(UUID reservaId);

    List<ResenaDomain> consultarResenas(ResenaDomain filtro);

}
