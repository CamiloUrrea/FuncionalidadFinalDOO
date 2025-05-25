package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.EstadoVerificacionBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoVerificacionDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class EstadoVerificacionBusinessLogicImpl implements EstadoVerificacionBusinessLogic {

    public EstadoVerificacionBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoEstadoVerificacion(EstadoVerificacionDomain estadoVerificacion) {

    }

    @Override
    public void modificarEstadoVerificacionExistente(UUID id, EstadoVerificacionDomain estadoVerificacion) {

    }

    @Override
    public void darBajaDefinitivamenteEstadoVerificacionExistente(UUID id) {

    }

    @Override
    public EstadoVerificacionDomain consultarEstadoVerificacionPorId(UUID id) {
        return null;
    }

    @Override
    public List<EstadoVerificacionDomain> consultarEstadoVerificacions(EstadoVerificacionDomain filtro) {
        return List.of();
    }
}
