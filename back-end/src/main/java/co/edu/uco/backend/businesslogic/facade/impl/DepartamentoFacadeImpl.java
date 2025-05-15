package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.DepartamentoBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.DepartamentoFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.DepartamentoDTO;

import java.util.List;
import java.util.UUID;

public class DepartamentoFacadeImpl implements DepartamentoFacade {

    private DAOFactory daoFactory;
    private DepartamentoBusinessLogic businessLogic;

    public DepartamentoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new DepartamentoBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoDepartamento(DepartamentoDTO dto) {

    }

    @Override
    public void modificarDepartamento(UUID id, DepartamentoDTO dto) {

    }

    @Override
    public void darBajaDefinitivaDepartamentoExistente(UUID id) {

    }

    @Override
    public DepartamentoDTO consultarDepartamentoPorId(UUID id) {
        return null;
    }

    @Override
    public List<DepartamentoDTO> consultarDepartamentosPorFiltro(DepartamentoDTO filtro) {
        return List.of();
    }
}
