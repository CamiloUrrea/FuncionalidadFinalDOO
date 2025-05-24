package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.HorarioDisponibleBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioDisponibleDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class HorarioDisponibleBusinessLogicImpl implements HorarioDisponibleBusinessLogic {

    public HorarioDisponibleBusinessLogicImpl(DAOFactory daoFactory) {

    }

    @Override
    public void registrarNuevoHorarioDisponible(UUID canchaId, HorarioDisponibleDomain horarioDisponible) {

    }

    @Override
    public void modificarHorarioDisponibleExistente(UUID canchaId, UUID horarioDisponinbleID, HorarioDisponibleDomain horarioDisponible) {

    }


    @Override
    public void darBajaDefinitivamenteHorarioDisponibleExistente(UUID canchaId, UUID horarioDisponibleId) {
        
    }

    @Override
    public HorarioDisponibleDomain consultarHorarioDisponiblePorId(UUID canchaId, UUID horarioDisponibleId) {
        return null;
    }

    @Override
    public List<HorarioDisponibleDomain> consultarHorariosDisponiblesPorCancha(UUID canchaId, HorarioDisponibleDomain filtro) {
        return List.of();
    }


}
