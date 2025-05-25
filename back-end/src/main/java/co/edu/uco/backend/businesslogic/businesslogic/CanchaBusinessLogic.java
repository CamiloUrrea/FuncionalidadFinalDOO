package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;

import java.util.List;
import java.util.UUID;

public interface CanchaBusinessLogic {

    void registrarNuevaCancha(UUID orgId, CanchaDomain cancha) throws BackEndException;

    void modificarCanchaExistente(UUID orgId, UUID canchaId, CanchaDomain cancha) throws BackEndException;

    void darBajaDefinitivamenteCanchaExistente(UUID orgId, UUID canchaId) throws BackEndException;

    CanchaDomain consultarCanchaPorId(UUID orgId, UUID canchaId);

    List<CanchaDomain> consultarMisCanchas(UUID orgId, CanchaDomain filtro) throws BackEndException;

}
