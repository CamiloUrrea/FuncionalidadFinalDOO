package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.ResenaDomain;

import java.util.List;
import java.util.UUID;

public interface ResenaBusinessLogic {

    void registrarNuevoResena(ResenaDomain resena);

    void modificarResenaExistente(UUID resenaId, ResenaDomain resena);

    void darBajaDefinitivamenteResenaExistente(UUID resenaId);

    ResenaDomain consultarResenaPorId(UUID resenaId);

    List<ResenaDomain> consultarResenas(ResenaDomain filtro);

}
