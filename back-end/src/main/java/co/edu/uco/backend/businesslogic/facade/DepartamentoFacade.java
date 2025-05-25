package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.DepartamentoDTO;

import java.util.List;
import java.util.UUID;

public interface DepartamentoFacade {

    void registrarNuevoDepartamento(DepartamentoDTO departamento);

    void modificarDepartamentoExistente(UUID departamentoId, DepartamentoDTO departamento);

    void darBajaDefinitivamenteDepartamentoExistente(UUID departamentoId);

    DepartamentoDTO consultarDepartamentoPorId(UUID departamentoId);

    List<DepartamentoDTO> consultarDepartamentosPorFiltro(DepartamentoDTO filtro);

}
