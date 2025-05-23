package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class FacturaBusinessLogicImpl implements FacturaBusinessLogic {

    public FacturaBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoFactura(FacturaDomain domain) {

    }

    @Override
    public void modificarFacturaExistente(UUID id, FacturaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteFacturaExistente(UUID id) {

    }

    @Override
    public FacturaDomain consultarFacturaPorId(UUID id) {
        return null;
    }

    @Override
    public List<FacturaDomain> consultarFacturas(FacturaDomain filtro) {
        return List.of();
    }
}
