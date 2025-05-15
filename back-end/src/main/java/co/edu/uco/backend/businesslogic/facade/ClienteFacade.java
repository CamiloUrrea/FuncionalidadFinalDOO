package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteFacade {

    void registrarNuevoCliente(ClienteDTO dto);

    void modificarCliente(UUID id, ClienteDTO dto);

    void darBajaDefinitivaClienteExistente(UUID id);

    ClienteDTO consultarClientePorId(UUID id);

    List<ClienteDTO> consultarClientesPorFiltro(ClienteDTO filtro);

}
