package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.ReservaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ReservaDomain;

import java.util.List;
import java.util.UUID;

public class ReservaBusinessLogicImpl implements ReservaBusinessLogic {

    @Override
    public void registrarNuevoReserva(ReservaDomain domain) {

    }

    @Override
    public void modificarReservaExistente(UUID id, ReservaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteReservaExistente(UUID id) {

    }

    @Override
    public ReservaDomain consultarReservaPorId(UUID id) {
        return null;
    }

    @Override
    public List<ReservaDomain> consultarReservas(ReservaDomain filtro) {
        return List.of();
    }
}
