package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteFacade extends UsuarioFacade {

    void registrarNuevoCliente(ClienteDTO cliente);

    void modificarClienteExistente(UUID clienteId, ClienteDTO cliente);

    void darBajaDefinitivamenteClienteExistente(UUID clienteId);

    ClienteDTO consultarClientePorId(UUID clienteId);

    List<ClienteDTO> consultarClientesPorFiltro(ClienteDTO filtro);

}
