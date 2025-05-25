package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.EncargadoDTO;

import java.util.List;
import java.util.UUID;

public interface EncargadoFacade extends UsuarioFacade {

    UUID registrarNuevoEncargado(UUID orgId, EncargadoDTO domain);

    void modificarEncargadoExistente(UUID orgId, UUID encargadoID, EncargadoDTO domain);

    void darBajaDefinitivamenteEncargadoExistente(UUID orgId, UUID encargadoId);

    EncargadoDTO consultarEncargadoPorId(UUID orgId, UUID encargadoId);

    List<EncargadoDTO> consultarEncargadosPorOrganizacion(UUID orgId, EncargadoDTO filtro);

    String activarCuentaEncargado(String tokenDeActivacion, String rawPasswordNueva);

}
