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
    public void registrarNuevaFactura(UUID reservaId, FacturaDomain factura) {

    }

    @Override
    public void modificarFacturaExistente(UUID reservaId, UUID facturaId, FacturaDomain factura) {

    }

    @Override
    public void darBajaDefinitivamenteFacturaExistente(UUID reservaId, UUID facturaId) {

    }

    @Override
    public FacturaDomain consultarFacturaPorId(UUID reservaId, UUID facturaid) {
        return null;
    }

    @Override
    public List<FacturaDomain> consultarFacturasPorReserva(UUID reservaId, FacturaDomain filtro) {
        return List.of();
    }



    @Override
    public byte[] generarPdfFactura(UUID reservaId, UUID facturaId) {
        return new byte[0];
    }
}
