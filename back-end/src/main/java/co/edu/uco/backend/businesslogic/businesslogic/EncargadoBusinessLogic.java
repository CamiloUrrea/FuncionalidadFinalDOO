package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.EncargadoDomain;

import java.util.List;
import java.util.UUID;

public interface EncargadoBusinessLogic extends UsuarioBusinessLogic {

    UUID registrarNuevoEncargado(UUID orgId, EncargadoDomain domain);

    void modificarEncargadoExistente(UUID orgId, UUID encargadoID, EncargadoDomain domain);

    void darBajaDefinitivamenteEncargadoExistente(UUID orgId, UUID encargadoId);

    EncargadoDomain consultarEncargadoPorId(UUID orgId, UUID encargadoId);

    List<EncargadoDomain> consultarEncargadosPorOrganizacion(UUID orgId, EncargadoDomain filtro);

    String activarCuentaEncargado(String tokenDeActivacion, String rawPasswordNueva);

}
