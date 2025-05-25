package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.SuperficieDomain;

import java.util.List;
import java.util.UUID;

public interface SuperficieBusinessLogic {

    void registrarNuevoSuperficie(SuperficieDomain superficie);

    void modificarSuperficieExistente(UUID id, SuperficieDomain superficie);

    void darBajaDefinitivamenteSuperficieExistente(UUID id);

    SuperficieDomain consultarSuperficiePorId(UUID id);

    List<SuperficieDomain> consultarSuperficies(SuperficieDomain filtro);

}
