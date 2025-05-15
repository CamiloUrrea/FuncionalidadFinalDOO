package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.ClienteBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.ClienteFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public class ClienteFacadeImpl implements ClienteFacade {

    private DAOFactory daoFactory;
    private ClienteBusinessLogic businessLogic;

    public ClienteFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new ClienteBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoCliente(ClienteDTO dto) {

    }

    @Override
    public void modificarCliente(UUID id, ClienteDTO dto) {

    }

    @Override
    public void darBajaDefinitivaClienteExistente(UUID id) {

    }

    @Override
    public ClienteDTO consultarClientePorId(UUID id) {
        return null;
    }

    @Override
    public List<ClienteDTO> consultarClientesPorFiltro(ClienteDTO filtro) {
        return List.of();
    }
}
