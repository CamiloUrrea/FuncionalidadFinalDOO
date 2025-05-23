package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.CanchaHorarioEspecialBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioEspecialDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class CanchaHorarioEspecialBusinessLogicImpl implements CanchaHorarioEspecialBusinessLogic {

    public CanchaHorarioEspecialBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoHorarioEspecial(UUID canchaId, HorarioEspecialDomain horarioEspecial) {

    }

    @Override
    public void modificarHorarioEspecialExistente(UUID canchaId, HorarioEspecialDomain horario) {

    }

    @Override
    public void darBajaDefinitivamenteHorarioEspecialExistente(UUID canchaId, UUID horarioEspecialId) {

    }


    @Override
    public List<HorarioEspecialDomain> consultarHorariosEspeciales(UUID canchaId) {
        return List.of();
    }

}
