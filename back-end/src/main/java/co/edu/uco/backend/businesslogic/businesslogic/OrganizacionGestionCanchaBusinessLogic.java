package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;

import java.util.List;
import java.util.UUID;

public interface OrganizacionGestionCanchaBusinessLogic {

    UUID registrarNuevaCancha(UUID orgId, CanchaDomain cancha);

    void modificarCanchaExistente(UUID orgId, CanchaDomain cancha);

    void darBajaDefinitivamenteCanchaExistente(UUID orgId, UUID canchaId);

    CanchaDomain consultarCanchaPorId(UUID orgId, UUID canchaId);

    List<CanchaDomain> consultarMisCanchas(UUID orgId, CanchaDomain filtro);

}
