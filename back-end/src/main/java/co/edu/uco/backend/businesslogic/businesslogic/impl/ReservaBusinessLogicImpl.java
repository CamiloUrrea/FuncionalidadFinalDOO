package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.ReservaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ReservaDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class ReservaBusinessLogicImpl implements ReservaBusinessLogic {


    public ReservaBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevaReserva(UUID clienteID, ReservaDomain domain) {

    }

    @Override
    public void confirmarReserva(UUID clienteId, UUID idReserva) {

    }


    @Override
    public void cancelarReservaPorCliente(UUID clienteId, UUID reservaId) {

    }

    @Override
    public ReservaDomain consultarReservaPorCliente(UUID clienteId, UUID reservaId) {
        return null;
    }

    @Override
    public List<ReservaDomain> listarReservasPorCliente(UUID clienteId, ReservaDomain filtro) {
        return List.of();
    }

    @Override
    public void finalizarReserva(UUID clienteId, UUID reservaId) {

    }


    @Override
    public void cancelarReservaPorOrganizacion(UUID orgId, UUID reservaId) {

    }

    @Override
    public List<ReservaDomain> listarReservasPorCancha(UUID orgId, UUID canchaId) {
        return List.of();
    }


}
