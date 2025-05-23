package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.CanchaHorarioDisponibleBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.DiaSemanaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioDisponibleDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class CanchaHorarioDisponibleBusinessLogicImpl implements CanchaHorarioDisponibleBusinessLogic {

    public CanchaHorarioDisponibleBusinessLogicImpl(DAOFactory daoFactory) {

    }

    @Override
    public void registrarNuevoHorarioDisponible(UUID canchaId, HorarioDisponibleDomain horarioDisponible) {

    }

    @Override
    public void modificarHorarioDisponibleExistente(UUID canchaId, HorarioDisponibleDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteHorarioDisponibleExistente(UUID canchaId, UUID horarioDisponibleId) {
        
    }
    

    @Override
    public List<HorarioDisponibleDomain> consultarHorariosDisponibles(UUID canchaId, DiaSemanaDomain dia) {
        return List.of();
    }


}
