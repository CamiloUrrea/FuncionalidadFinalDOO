package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.FacturaDTO;

import java.util.List;
import java.util.UUID;

public interface FacturaFacade {

    void registrarNuevoFactura(FacturaDTO dto);

    void modificarFactura(UUID id, FacturaDTO dto);

    void darBajaDefinitivaFacturaExistente(UUID id);

    FacturaDTO consultarFacturaPorId(UUID id);

    List<FacturaDTO> consultarFacturasPorFiltro(FacturaDTO filtro);

}
