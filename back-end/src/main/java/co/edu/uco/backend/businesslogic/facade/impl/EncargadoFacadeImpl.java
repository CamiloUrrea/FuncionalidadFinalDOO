package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.EncargadoBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.EncargadoBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.EncargadoFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.EncargadoDTO;
import co.edu.uco.backend.dto.UsuarioDTO;

import java.util.List;
import java.util.UUID;

public class EncargadoFacadeImpl implements EncargadoFacade {

    private DAOFactory daoFactory;
    private EncargadoBusinessLogic encargadoBusinessLogic;

    public EncargadoFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
        encargadoBusinessLogic = new EncargadoBusinessLogicImpl(daoFactory);
    }


    @Override
    public UUID registrarNuevoEncargado(UUID orgId, EncargadoDTO domain) {
        return null;
    }

    @Override
    public void modificarEncargadoExistente(UUID orgId, UUID encargadoID, EncargadoDTO domain) {

    }

    @Override
    public void darBajaDefinitivamenteEncargadoExistente(UUID orgId, UUID encargadoId) {

    }

    @Override
    public EncargadoDTO consultarEncargadoPorId(UUID orgId, UUID encargadoId) {
        return null;
    }

    @Override
    public List<EncargadoDTO> consultarEncargadosPorOrganizacion(UUID orgId, EncargadoDTO filtro) {
        return List.of();
    }

    @Override
    public String activarCuentaEncargado(String tokenDeActivacion, String rawPasswordNueva) {
        return "";
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
    public List<UsuarioDTO> listarUsuarios(UsuarioDTO filtro) {
        return List.of();
    }

}
