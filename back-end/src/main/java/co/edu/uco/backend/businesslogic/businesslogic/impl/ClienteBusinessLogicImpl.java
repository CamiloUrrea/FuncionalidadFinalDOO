package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class ClienteBusinessLogicImpl implements ClienteBusinessLogic {

    public ClienteBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoCliente(ClienteDomain domain) {

    }

    @Override
    public void modificarClienteExistente(UUID id, ClienteDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteClienteExistente(UUID id) {

    }

    @Override
    public ClienteDomain consultarClientePorId(UUID id) {
        return null;
    }

    @Override
    public List<ClienteDomain> consultarClientes(ClienteDomain filtro) {
        return List.of();
    }
}
