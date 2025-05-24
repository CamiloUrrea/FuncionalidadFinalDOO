package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.EncargadoBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.EncargadoDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class EncargadoBusinessLogicImpl implements EncargadoBusinessLogic {


    public EncargadoBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public UUID registrarNuevoEncargado(UUID orgId, EncargadoDomain domain) {

        return null;
    }

    @Override
    public void modificarEncargadoExistente(UUID orgid, EncargadoDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteEncargadoExistente(UUID orgId, UUID encargadoId) {

    }


    @Override
    public List<EncargadoDomain> consultarMisEncargados(UUID orgId, EncargadoDomain filtro) {
        return List.of();
    }

    @Override
    public String activarCuentaEncargado(String tokenDeActivacion, String rawPasswordNueva) {
        return "";
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
