package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.entity.ClienteEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClienteBusinessLogicImpl implements ClienteBusinessLogic {

    private DAOFactory factory;
    public ClienteBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevoCliente(ClienteDomain cliente) throws BackEndException {
        ClienteEntity clienteEntity = null;
        factory.getClienteDAO().crear(clienteEntity);
    }

    @Override
    public void modificarClienteExistente(UUID clienteId, ClienteDomain datosActualizados) throws BackEndException {
        ClienteEntity clienteEntity = null;
        factory.getClienteDAO().modificar(clienteId,clienteEntity);
    }

    @Override
    public void darBajaDefinitivamenteClienteExistente(UUID clienteId) throws BackEndException {
        ClienteEntity clienteEntity = null;
        factory.getClienteDAO().eliminar(clienteId);

    }

    @Override
    public ClienteDomain consultarClientePorId(UUID clienteId) throws BackEndException {
        ClienteEntity clienteEntity = null;
        factory.getClienteDAO().consultarPorId(clienteId);
        return null;
    }

    @Override
    public List<ClienteDomain> consultarClientes(ClienteDomain filtro) throws BackEndException {
        ClienteEntity clienteFilter = null;
        List<ClienteEntity> clienteEntities = factory.getClienteDAO().consultar(clienteFilter);
        List<ClienteDomain> datosAretornar= null;
        return datosAretornar;
    }

    @Override
    public UsuarioDomain iniciarSesion(String username, String rawPassword) {
        //TODO: Logica de iniciarSesion
        return null;
    }

    @Override
    public void cerrarSesion(UUID usuarioId) {
        //TODO: Logica de cerrarSesion
    }

    @Override
    public void recuperarContrasena(String username) {
        //TODO: Logica de recuperarConstraseña
    }

    @Override
    public void cambiarContrasena(UUID usuarioId, String rawPasswordActual, String rawPasswordNueva) {
        //TODO: Logica de cambiarConstraseña
    }

    @Override
    public UsuarioDomain consultarUsuarioPorId(UUID usuarioId) {
        return null;
    }

    @Override
    public List<UsuarioDomain> listarUsuarios(UsuarioDomain filtro) {
        return List.of();
    }


}
