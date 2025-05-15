package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.OrganizacionDeportivaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionDeportivaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.OrganizacionDeportivaFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.OrganizacionDeportivaDTO;

import java.util.List;
import java.util.UUID;

public class OrganizacionDeportivaFacadeImpl implements OrganizacionDeportivaFacade {

    private DAOFactory daoFactory;
    private OrganizacionDeportivaBusinessLogic businessLogic;

    public OrganizacionDeportivaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new OrganizacionDeportivaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoOrganizacionDeportiva(OrganizacionDeportivaDTO dto) {

    }

    @Override
    public void modificarOrganizacionDeportiva(UUID id, OrganizacionDeportivaDTO dto) {

    }

    @Override
    public void darBajaDefinitivaOrganizacionDeportivaExistente(UUID id) {

    }

    @Override
    public OrganizacionDeportivaDTO consultarOrganizacionDeportivaPorId(UUID id) {
        return null;
    }

    @Override
    public List<OrganizacionDeportivaDTO> consultarOrganizacionDeportivasPorFiltro(OrganizacionDeportivaDTO filtro) {
        return List.of();
    }
}
