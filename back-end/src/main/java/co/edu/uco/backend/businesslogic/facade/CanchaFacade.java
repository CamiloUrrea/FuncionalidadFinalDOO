package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.CanchaDTO;

import java.util.List;
import java.util.UUID;

public interface CanchaFacade {

    void registrarNuevaCancha(UUID orgId, CanchaDTO cancha) ;

    void modificarCanchaExistente(UUID orgId, UUID canchaId, CanchaDTO cancha) ;

    void darBajaDefinitivamenteCanchaExistente(UUID orgId, UUID canchaId) ;

    CanchaDTO consultarCanchaPorId(UUID orgId, UUID canchaId);

    List<CanchaDTO> consultarMisCanchas(UUID orgId, CanchaDTO filtro) ;

}
