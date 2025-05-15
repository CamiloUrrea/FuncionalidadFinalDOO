package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.FacturaDomain;

import java.util.List;
import java.util.UUID;

public interface FacturaBusinessLogic {

    void registrarNuevoFactura(FacturaDomain domain);

    void modificarFacturaExistente(UUID id, FacturaDomain domain);

    void darBajaDefinitivamenteFacturaExistente(UUID id);

    FacturaDomain consultarFacturaPorId(UUID id);

    List<FacturaDomain> consultarFacturas(FacturaDomain filtro);

}
