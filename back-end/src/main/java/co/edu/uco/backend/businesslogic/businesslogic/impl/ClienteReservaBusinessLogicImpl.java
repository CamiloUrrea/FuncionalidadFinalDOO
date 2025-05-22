package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.ClienteReservaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoReservaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ReservaDomain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ClienteReservaBusinessLogicImpl implements ClienteReservaBusinessLogic {


    @Override
    public void registrarNuevaReserva(UUID clienteID, ReservaDomain domain) {

    }

    @Override
    public void modificarReservaExistente(UUID id, ReservaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteReservaExistente(UUID clienteId, UUID reservaId) {

    }

    @Override
    public ReservaDomain consultarReservaPorId(UUID clienteId, UUID reservaId) {
        return null;
    }

    @Override
    public List<ReservaDomain> consultarReservas(UUID clienteId, ReservaDomain filtro) {
        return List.of();
    }

    @Override
    public void actualizarEstadoReserva(UUID reservaId, EstadoReservaDomain nuevoEstado) {

    }

}
