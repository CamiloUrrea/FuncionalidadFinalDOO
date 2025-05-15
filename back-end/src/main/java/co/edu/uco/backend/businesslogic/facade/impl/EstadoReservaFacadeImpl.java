package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.EstadoReservaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.EstadoReservaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.EstadoReservaFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.EstadoReservaDTO;

import java.util.List;
import java.util.UUID;

public class EstadoReservaFacadeImpl implements EstadoReservaFacade {

    private DAOFactory daoFactory;
    private EstadoReservaBusinessLogic businessLogic;

    public EstadoReservaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new EstadoReservaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoEstadoReserva(EstadoReservaDTO dto) {

    }

    @Override
    public void modificarEstadoReserva(UUID id, EstadoReservaDTO dto) {

    }

    @Override
    public void darBajaDefinitivaEstadoReservaExistente(UUID id) {

    }

    @Override
    public EstadoReservaDTO consultarEstadoReservaPorId(UUID id) {
        return null;
    }

    @Override
    public List<EstadoReservaDTO> consultarEstadoReservasPorFiltro(EstadoReservaDTO filtro) {
        return List.of();
    }
}
