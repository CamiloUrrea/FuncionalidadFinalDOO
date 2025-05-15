package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.HorarioDisponibleBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.HorarioDisponibleBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.HorarioDisponibleFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.HorarioDisponibleDTO;

import java.util.List;
import java.util.UUID;

public class HorarioDisponibleFacadeImpl implements HorarioDisponibleFacade {

    private DAOFactory daoFactory;
    private HorarioDisponibleBusinessLogic businessLogic;

    public HorarioDisponibleFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new HorarioDisponibleBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoHorarioDisponible(HorarioDisponibleDTO dto) {

    }

    @Override
    public void modificarHorarioDisponible(UUID id, HorarioDisponibleDTO dto) {

    }

    @Override
    public void darBajaDefinitivaHorarioDisponibleExistente(UUID id) {

    }

    @Override
    public HorarioDisponibleDTO consultarHorarioDisponiblePorId(UUID id) {
        return null;
    }

    @Override
    public List<HorarioDisponibleDTO> consultarHorarioDisponiblesPorFiltro(HorarioDisponibleDTO filtro) {
        return List.of();
    }
}
