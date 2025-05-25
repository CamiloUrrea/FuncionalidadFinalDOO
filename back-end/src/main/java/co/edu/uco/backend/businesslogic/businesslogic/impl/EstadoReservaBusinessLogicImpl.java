package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.EstadoReservaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoReservaDomain;

import java.util.List;
import java.util.UUID;

public class EstadoReservaBusinessLogicImpl implements EstadoReservaBusinessLogic {

    @Override
    public void registrarNuevoEstadoReserva(EstadoReservaDomain estadoReserva) {

    }

    @Override
    public void modificarEstadoReservaExistente(UUID id, EstadoReservaDomain estadoReserva) {

    }

    @Override
    public void darBajaDefinitivamenteEstadoReservaExistente(UUID id) {

    }

    @Override
    public EstadoReservaDomain consultarEstadoReservaPorId(UUID id) {
        return null;
    }

    @Override
    public List<EstadoReservaDomain> consultarEstadoReservas(EstadoReservaDomain filtro) {
        return List.of();
    }
}
