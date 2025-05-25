package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoVerificacionDomain;

import java.util.List;
import java.util.UUID;

public interface EstadoVerificacionBusinessLogic {

    void registrarNuevoEstadoVerificacion(EstadoVerificacionDomain estadoVerificacion);

    void modificarEstadoVerificacionExistente(UUID estadoVerificacionId, EstadoVerificacionDomain estadoVerificacion);

    void darBajaDefinitivamenteEstadoVerificacionExistente(UUID estadoVerificacionId);

    EstadoVerificacionDomain consultarEstadoVerificacionPorId(UUID estadoVerificacionId);

    List<EstadoVerificacionDomain> consultarEstadoVerificacions(EstadoVerificacionDomain filtro);

}
