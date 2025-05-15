package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.ClienteDomain;

import java.util.List;
import java.util.UUID;

public interface ClienteBusinessLogic {

    void registrarNuevoCliente(ClienteDomain domain);

    void modificarClienteExistente(UUID id, ClienteDomain domain);

    void darBajaDefinitivamenteClienteExistente(UUID id);

    ClienteDomain consultarClientePorId(UUID id);

    List<ClienteDomain> consultarClientes(ClienteDomain filtro);

}
