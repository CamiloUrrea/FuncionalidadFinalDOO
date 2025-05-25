package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.HorarioDisponibleBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.HorarioDisponibleBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.HorarioDisponibleFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.HorarioDisponibleDTO;

import java.util.List;
import java.util.UUID;

public class HorarioDisponibleFacadeImpl implements HorarioDisponibleFacade {

    private DAOFactory daoFactory;
    private HorarioDisponibleBusinessLogic horarioDisponibleBusinessLogic;

    public HorarioDisponibleFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
        horarioDisponibleBusinessLogic = new HorarioDisponibleBusinessLogicImpl(daoFactory);
    }


    @Override
    public void registrarNuevoHorarioDisponible(UUID canchaId, HorarioDisponibleDTO horarioDisponible) {

    }

    @Override
    public void modificarHorarioDisponibleExistente(UUID canchaId, UUID horarioDisponinbleID, HorarioDisponibleDTO horarioDisponible) {

    }

    @Override
    public void darBajaDefinitivamenteHorarioDisponibleExistente(UUID canchaId, UUID horarioDisponibleId) {

    }

    @Override
    public HorarioDisponibleDTO consultarHorarioDisponiblePorId(UUID canchaId, UUID horarioDisponibleId) {
        return null;
    }

    @Override
    public List<HorarioDisponibleDTO> consultarHorariosDisponiblesPorCancha(UUID canchaId, HorarioDisponibleDTO filtro) {
        return List.of();
    }
}
