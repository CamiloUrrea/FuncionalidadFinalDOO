package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoVerificacionDomain;

import java.util.List;
import java.util.UUID;

public interface EstadoVerificacionBusinessLogic {

    void registrarNuevoEstadoVerificacion(EstadoVerificacionDomain domain);

    void modificarEstadoVerificacionExistente(UUID id, EstadoVerificacionDomain domain);

    void darBajaDefinitivamenteEstadoVerificacionExistente(UUID id);

    EstadoVerificacionDomain consultarEstadoVerificacionPorId(UUID id);

    List<EstadoVerificacionDomain> consultarEstadoVerificacions(EstadoVerificacionDomain filtro);

}
