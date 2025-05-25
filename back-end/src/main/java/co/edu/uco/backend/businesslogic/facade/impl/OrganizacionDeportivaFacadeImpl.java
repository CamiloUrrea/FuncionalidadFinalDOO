package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.OrganizacionDeportivaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionDeportivaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.OrganizacionDeportivaFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.OrganizacionDeportivaDTO;
import co.edu.uco.backend.dto.UsuarioDTO;

import java.util.List;
import java.util.UUID;

public class OrganizacionDeportivaFacadeImpl implements OrganizacionDeportivaFacade {

    private DAOFactory daoFactory;
    private OrganizacionDeportivaBusinessLogic organizacionDeportivaBusinessLogic;

    public OrganizacionDeportivaFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
        organizacionDeportivaBusinessLogic = new OrganizacionDeportivaBusinessLogicImpl(daoFactory);
    }


    @Override
    public void registrarNuevaOrganizacionDeportiva(OrganizacionDeportivaDTO organizacionDeportiva) {

    }

    @Override
    public void modificarOrganizacionDeportivaExistente(UUID orgId, OrganizacionDeportivaDTO organizacionDeportiva) {

    }

    @Override
    public void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID orgId) {

    }

    @Override
    public OrganizacionDeportivaDTO consultarOrganizacionDeportivaPorId(UUID orgId) {
        return null;
    }

    @Override
    public List<OrganizacionDeportivaDTO> consultarOrganizacionesDeportivas(OrganizacionDeportivaDTO filtro) {
        return List.of();
    }

    @Override
    public void aceptarOrganizacion(UUID orgId) {

    }

    @Override
    public void rechazarOrganizacion(UUID orgId) {

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
