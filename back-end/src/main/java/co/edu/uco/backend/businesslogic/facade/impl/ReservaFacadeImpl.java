package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.ReservaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.ReservaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.ReservaFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.ReservaDTO;

import java.util.List;
import java.util.UUID;

public class ReservaFacadeImpl implements ReservaFacade {

    private DAOFactory daoFactory;
    private ReservaBusinessLogic businessLogic;

    public ReservaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new ReservaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoReserva(ReservaDTO dto) {

    }

    @Override
    public void modificarReserva(UUID id, ReservaDTO dto) {

    }

    @Override
    public void darBajaDefinitivaReservaExistente(UUID id) {

    }

    @Override
    public ReservaDTO consultarReservaPorId(UUID id) {
        return null;
    }

    @Override
    public List<ReservaDTO> consultarReservasPorFiltro(ReservaDTO filtro) {
        return List.of();
    }
}
