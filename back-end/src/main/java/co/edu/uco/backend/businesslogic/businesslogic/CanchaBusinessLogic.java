package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;

import java.util.List;
import java.util.UUID;

public interface CanchaBusinessLogic {

    void registrarNuevaCancha(UUID orgId, CanchaDomain cancha);

    void modificarCanchaExistente(UUID orgId, UUID canchaId, CanchaDomain cancha);

    void darBajaDefinitivamenteCanchaExistente(UUID orgId, UUID canchaId);

    CanchaDomain consultarCanchaPorId(UUID orgId, UUID canchaId);

    List<CanchaDomain> consultarMisCanchas(UUID orgId, CanchaDomain filtro);

}
