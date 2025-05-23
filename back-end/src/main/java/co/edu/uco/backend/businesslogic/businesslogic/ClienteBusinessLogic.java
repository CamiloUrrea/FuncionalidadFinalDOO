package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.ClienteDomain;

import java.util.List;
import java.util.UUID;

public interface ClienteBusinessLogic {

    void registrarNuevoCliente(ClienteDomain cliente);

    void modificarClienteExistente(UUID clienteId, ClienteDomain cliente);

    void darBajaDefinitivamenteClienteExistente(UUID clienteId);

    ClienteDomain consultarClientePorId(UUID clienteId);

    List<ClienteDomain> consultarClientes(ClienteDomain filtro);

}
