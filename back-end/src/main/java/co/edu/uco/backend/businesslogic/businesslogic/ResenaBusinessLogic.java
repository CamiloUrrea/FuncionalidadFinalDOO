package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.ResenaDomain;

import java.util.List;
import java.util.UUID;

public interface ResenaBusinessLogic {

    void registrarNuevoResena(ResenaDomain domain);

    void modificarResenaExistente(UUID id, ResenaDomain domain);

    void darBajaDefinitivamenteResenaExistente(UUID id);

    ResenaDomain consultarResenaPorId(UUID id);

    List<ResenaDomain> consultarResenas(ResenaDomain filtro);

}
