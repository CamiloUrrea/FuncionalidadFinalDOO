package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.DiaSemanaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.facade.DiaSemanaFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.DiaSemanaDTO;

import java.util.List;
import java.util.UUID;

public class DiaSemanaFacadeImpl implements DiaSemanaFacade {

    private DAOFactory daoFactory;
    private DiaSemanaBusinessLogic businessLogic;

    public DiaSemanaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new DiaSemanaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoDiaSemana(DiaSemanaDTO dto) {

    }

    @Override
    public void modificarDiaSemana(UUID id, DiaSemanaDTO dto) {

    }

    @Override
    public void darBajaDefinitivaDiaSemanaExistente(UUID id) {

    }

    @Override
    public DiaSemanaDTO consultarDiaSemanaPorId(UUID id) {
        return null;
    }

    @Override
    public List<DiaSemanaDTO> consultarDiaSemanasPorFiltro(DiaSemanaDTO filtro) {
        return List.of();
    }
}
