package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionDeportivaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.CanchaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.OrganizacionDeportivaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class OrganizacionDeportivaBusinessLogicImpl implements OrganizacionDeportivaBusinessLogic {

    public OrganizacionDeportivaBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevaOrganizacionDeportiva(OrganizacionDeportivaDomain organizacionDeportiva) {

    }

    @Override
    public void modificarOrganizacionDeportivaExistente(UUID id, OrganizacionDeportivaDomain organizacionDeportiva) {

    }

    @Override
    public void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID id) {

    }

    @Override
    public OrganizacionDeportivaDomain consultarOrganizacionDeportivaPorId(UUID id) {
        return null;
    }

    @Override
    public List<OrganizacionDeportivaDomain> consultarOrganizacionesDeportivas(OrganizacionDeportivaDomain filtro) {
        return List.of();
    }

    @Override
    public void aceptarOrganizacion(UUID orgId) {

    }

    @Override
    public void rechazarOrganizacion(UUID orgId) {

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
