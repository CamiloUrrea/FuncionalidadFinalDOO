package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.DepartamentoDTO;

import java.util.List;
import java.util.UUID;

public interface DepartamentoFacade {

    void registrarNuevoDepartamento(DepartamentoDTO dto);

    void modificarDepartamento(UUID id, DepartamentoDTO dto);

    void darBajaDefinitivaDepartamentoExistente(UUID id);

    DepartamentoDTO consultarDepartamentoPorId(UUID id);

    List<DepartamentoDTO> consultarDepartamentosPorFiltro(DepartamentoDTO filtro);

}
