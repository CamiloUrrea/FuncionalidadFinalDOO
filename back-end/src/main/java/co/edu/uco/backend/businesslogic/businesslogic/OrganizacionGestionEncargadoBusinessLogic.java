package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.EncargadoDomain;

import java.util.List;
import java.util.UUID;

public interface OrganizacionGestionEncargadoBusinessLogic {

    void registrarNuevoEncargado(UUID orgId, EncargadoDomain domain);

    void modificarEncargadoExistente(UUID orgId, EncargadoDomain domain);

    void darBajaDefinitivamenteEncargadoExistente(UUID orgId, UUID encargadoId);

    List<EncargadoDomain> consultarMisEncargados(UUID orgId, EncargadoDomain filtro);

}
