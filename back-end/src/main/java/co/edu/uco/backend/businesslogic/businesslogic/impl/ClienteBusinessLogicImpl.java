package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class ClienteBusinessLogicImpl implements ClienteBusinessLogic {

    public ClienteBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoCliente(ClienteDomain cliente) {

    }

    @Override
    public void modificarClienteExistente(UUID id, ClienteDomain datosActualizados) {

    }

    @Override
    public void darBajaDefinitivamenteClienteExistente(UUID clienteId) {

    }

    @Override
    public ClienteDomain consultarClientePorId(UUID clienteId) {
        return null;
    }

    @Override
    public List<ClienteDomain> consultarClientes(ClienteDomain filtro) {
        return List.of();
    }

    @Override
    public UsuarioDomain iniciarSesion(String username, String rawPassword) {
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
    public UsuarioDomain consultarUsuarioPorId(UUID usuarioId) {
        return null;
    }

    @Override
    public List<CanchaDomain> consultarcualquierCancha(CanchaDomain filtro) {
        return List.of();
    }

}
