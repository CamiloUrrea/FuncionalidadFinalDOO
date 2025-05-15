package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.DepartamentoDomain;

import java.util.List;
import java.util.UUID;

public interface DepartamentoBusinessLogic {

    void registrarNuevoDepartamento(DepartamentoDomain domain);

    void modificarDepartamentoExistente(UUID id, DepartamentoDomain domain);

    void darBajaDefinitivamenteDepartamentoExistente(UUID id);

    DepartamentoDomain consultarDepartamentoPorId(UUID id);

    List<DepartamentoDomain> consultarDepartamentos(DepartamentoDomain filtro);

}
