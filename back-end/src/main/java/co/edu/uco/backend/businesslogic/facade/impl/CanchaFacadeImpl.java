package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.OrganizacionGestionCanchaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionGestionCanchaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.CanchaFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.CanchaDTO;

import java.util.List;
import java.util.UUID;

public class CanchaFacadeImpl implements CanchaFacade {

    private DAOFactory daoFactory;
    private OrganizacionGestionCanchaBusinessLogic businessLogic;

    public CanchaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new OrganizacionGestionCanchaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoCancha(CanchaDTO dto) {

    }

    @Override
    public void modificarCancha(UUID id, CanchaDTO dto) {

    }

    @Override
    public void darBajaDefinitivaCanchaExistente(UUID id) {

    }

    @Override
    public CanchaDTO consultarCanchaPorId(UUID id) {
        return null;
    }

    @Override
    public List<CanchaDTO> consultarCanchasPorFiltro(CanchaDTO filtro) {
        return List.of();
    }
}
