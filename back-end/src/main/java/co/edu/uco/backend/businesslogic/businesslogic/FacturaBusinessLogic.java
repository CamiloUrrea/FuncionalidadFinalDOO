package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.FacturaDomain;

import java.util.List;
import java.util.UUID;

public interface FacturaBusinessLogic {

    void registrarNuevaFactura(UUID reservaId, FacturaDomain factura);

    void modificarFacturaExistente(UUID reservaId, UUID facturaId, FacturaDomain factura);

    void darBajaDefinitivamenteFacturaExistente(UUID reservaId,UUID facturaId);

    FacturaDomain consultarFacturaPorId(UUID reservaId,UUID facturaid);

    List<FacturaDomain> consultarFacturasPorReserva(UUID reservaId, FacturaDomain filtro);

    byte[] generarPdfFactura(UUID reservaId, UUID facturaId);

}
