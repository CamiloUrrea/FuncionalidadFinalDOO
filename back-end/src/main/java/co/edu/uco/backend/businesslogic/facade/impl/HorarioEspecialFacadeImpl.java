package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.HorarioEspecialBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.HorarioEspecialBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.HorarioEspecialFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.HorarioEspecialDTO;

import java.util.List;
import java.util.UUID;

public class HorarioEspecialFacadeImpl implements HorarioEspecialFacade {

    private DAOFactory daoFactory;
    private HorarioEspecialBusinessLogic businessLogic;

    public HorarioEspecialFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new HorarioEspecialBusinessLogicImpl(daoFactory);
    }


    @Override
    public void registrarNuevoHorarioEspecial(UUID canchaId, HorarioEspecialDTO horarioEspecial) {

    }

    @Override
    public void modificarHorarioEspecialExistente(UUID canchaId, UUID horarioEspecialId, HorarioEspecialDTO horarioEspecial) {

    }

    @Override
    public void darBajaDefinitivamenteHorarioEspecialExistente(UUID canchaId, UUID horarioEspecialId) {

    }

    @Override
    public HorarioEspecialDTO consultarHorarioEspecialPorId(UUID canchaId, UUID horarioEspecialId) {
        return null;
    }

    @Override
    public List<HorarioEspecialDTO> consultarHorariosEspecialesPorCancha(UUID canchaId, HorarioEspecialDTO horarioEspecial) {
        return List.of();
    }
}
