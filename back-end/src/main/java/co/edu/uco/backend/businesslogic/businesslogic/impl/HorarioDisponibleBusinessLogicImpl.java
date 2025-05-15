package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.HorarioDisponibleBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioDisponibleDomain;

import java.util.List;
import java.util.UUID;

public class HorarioDisponibleBusinessLogicImpl implements HorarioDisponibleBusinessLogic {

    @Override
    public void registrarNuevoHorarioDisponible(HorarioDisponibleDomain domain) {

    }

    @Override
    public void modificarHorarioDisponibleExistente(UUID id, HorarioDisponibleDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteHorarioDisponibleExistente(UUID id) {

    }

    @Override
    public HorarioDisponibleDomain consultarHorarioDisponiblePorId(UUID id) {
        return null;
    }

    @Override
    public List<HorarioDisponibleDomain> consultarHorarioDisponibles(HorarioDisponibleDomain filtro) {
        return List.of();
    }
}
