package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.HorarioEspecialBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioEspecialDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class HorarioEspecialBusinessLogicImpl implements HorarioEspecialBusinessLogic {

    public HorarioEspecialBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoHorarioEspecial(UUID canchaId, HorarioEspecialDomain horarioEspecial) {

    }

    @Override
    public void modificarHorarioEspecialExistente(UUID canchaId, UUID horarioEspecialId, HorarioEspecialDomain horarioEspecial) {

    }


    @Override
    public void darBajaDefinitivamenteHorarioEspecialExistente(UUID canchaId, UUID horarioEspecialId) {

    }

    @Override
    public HorarioEspecialDomain consultarHorarioEspecialPorId(UUID canchaId, UUID horarioEspecialId) {
        return null;
    }

    @Override
    public List<HorarioEspecialDomain> consultarHorariosEspecialesPorCancha(UUID canchaId) {
        return List.of();
    }


}
