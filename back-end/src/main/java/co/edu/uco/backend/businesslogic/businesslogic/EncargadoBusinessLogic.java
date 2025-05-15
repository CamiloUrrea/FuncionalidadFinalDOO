package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.EncargadoDomain;

import java.util.List;
import java.util.UUID;

public interface EncargadoBusinessLogic {

    void registrarNuevoEncargado(EncargadoDomain domain);

    void modificarEncargadoExistente(UUID id, EncargadoDomain domain);

    void darBajaDefinitivamenteEncargadoExistente(UUID id);

    EncargadoDomain consultarEncargadoPorId(UUID id);

    List<EncargadoDomain> consultarEncargados(EncargadoDomain filtro);

}
