package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.FacturaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.FacturaFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.FacturaDTO;

import java.util.List;
import java.util.UUID;

public class FacturaFacadeImpl implements FacturaFacade {

    private DAOFactory daoFactory;
    private FacturaBusinessLogic businessLogic;

    public FacturaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new FacturaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoFactura(FacturaDTO dto) {

    }

    @Override
    public void modificarFactura(UUID id, FacturaDTO dto) {

    }

    @Override
    public void darBajaDefinitivaFacturaExistente(UUID id) {

    }

    @Override
    public FacturaDTO consultarFacturaPorId(UUID id) {
        return null;
    }

    @Override
    public List<FacturaDTO> consultarFacturasPorFiltro(FacturaDTO filtro) {
        return List.of();
    }
}
