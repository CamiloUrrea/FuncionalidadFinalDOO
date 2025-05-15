package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.HorarioEspecialBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioEspecialDomain;

import java.util.List;
import java.util.UUID;

public class HorarioEspecialBusinessLogicImpl implements HorarioEspecialBusinessLogic {

    @Override
    public void registrarNuevoHorarioEspecial(HorarioEspecialDomain domain) {

    }

    @Override
    public void modificarHorarioEspecialExistente(UUID id, HorarioEspecialDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteHorarioEspecialExistente(UUID id) {

    }

    @Override
    public HorarioEspecialDomain consultarHorarioEspecialPorId(UUID id) {
        return null;
    }

    @Override
    public List<HorarioEspecialDomain> consultarHorarioEspecials(HorarioEspecialDomain filtro) {
        return List.of();
    }
}
