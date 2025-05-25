package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.impl.ClienteBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.ClienteFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.ClienteDTO;
import co.edu.uco.backend.dto.UsuarioDTO;

import java.util.List;
import java.util.UUID;

public class ClienteFacadeImpl implements ClienteFacade {

    private DAOFactory daoFactory;
    private ClienteBusinessLogic businessLogic;

    public ClienteFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new ClienteBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoCliente(ClienteDTO cliente) {

    }

    @Override
    public void modificarClienteExistente(UUID clienteId, ClienteDTO cliente) {

    }

    @Override
    public void darBajaDefinitivamenteClienteExistente(UUID clienteId) {

    }

    @Override
    public ClienteDTO consultarClientePorId(UUID clienteId) {
        return null;
    }

    @Override
    public List<ClienteDTO> consultarClientesPorFiltro(ClienteDTO filtro) {
        return List.of();
    }

    @Override
    public UsuarioDTO iniciarSesion(String username, String rawPassword) {
        return null;
    }

    @Override
    public void cerrarSesion(UUID usuarioId) {

    }

    @Override
    public void recuperarContrasena(String username) {

    }

    @Override
    public void cambiarContrasena(UUID usuarioId, String rawPasswordActual, String rawPasswordNueva) {

    }

    @Override
    public UsuarioDTO consultarUsuarioPorId(UUID usuarioId) {
        return null;
    }

    @Override
    public List<CanchaDomain> consultarcualquierCancha(CanchaDomain filtro) {
        return List.of();
    }
}
