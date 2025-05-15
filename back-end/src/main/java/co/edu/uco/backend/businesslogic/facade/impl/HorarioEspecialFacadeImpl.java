package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.HorarioEspecialBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.HorarioEspecialBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.HorarioEspecialFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.HorarioEspecialDTO;

import java.util.List;
import java.util.UUID;

public class HorarioEspecialFacadeImpl implements HorarioEspecialFacade {

    private DAOFactory daoFactory;
    private HorarioEspecialBusinessLogic businessLogic;

    public HorarioEspecialFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new HorarioEspecialBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoHorarioEspecial(HorarioEspecialDTO dto) {

    }

    @Override
    public void modificarHorarioEspecial(UUID id, HorarioEspecialDTO dto) {

    }

    @Override
    public void darBajaDefinitivaHorarioEspecialExistente(UUID id) {

    }

    @Override
    public HorarioEspecialDTO consultarHorarioEspecialPorId(UUID id) {
        return null;
    }

    @Override
    public List<HorarioEspecialDTO> consultarHorarioEspecialsPorFiltro(HorarioEspecialDTO filtro) {
        return List.of();
    }
}
