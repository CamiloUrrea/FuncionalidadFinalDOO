package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.EstadoVerificacionDTO;

import java.util.List;
import java.util.UUID;

public interface EstadoVerificacionFacade {

    void registrarNuevoEstadoVerificacion(EstadoVerificacionDTO dto);

    void modificarEstadoVerificacion(UUID id, EstadoVerificacionDTO dto);

    void darBajaDefinitivaEstadoVerificacionExistente(UUID id);

    EstadoVerificacionDTO consultarEstadoVerificacionPorId(UUID id);

    List<EstadoVerificacionDTO> consultarEstadoVerificacionsPorFiltro(EstadoVerificacionDTO filtro);

}
