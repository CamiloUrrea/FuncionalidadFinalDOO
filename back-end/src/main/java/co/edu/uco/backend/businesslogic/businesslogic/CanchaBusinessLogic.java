package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;

import java.util.List;
import java.util.UUID;

public interface CanchaBusinessLogic {

    void registrarNuevoCancha(CanchaDomain domain);

    void modificarCanchaExistente(UUID id, CanchaDomain domain);

    void darBajaDefinitivamenteCanchaExistente(UUID id);

    CanchaDomain consultarCanchaPorId(UUID id);

    List<CanchaDomain> consultarCanchas(CanchaDomain filtro);

}
