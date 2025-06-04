package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.dto.OrganizacionDeportivaDTO;
import co.edu.uco.backend.dto.UsuarioDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizacionDeportivaFacade extends UsuarioFacade {

    @Override
    UsuarioDTO iniciarSesion(String username, String password, String ip, String userAgent) throws BackEndException;

    void registrarNuevaOrganizacionDeportiva(OrganizacionDeportivaDTO organizacionDeportiva) throws BackEndException;

    void modificarOrganizacionDeportivaExistente(UUID orgId, OrganizacionDeportivaDTO organizacionDeportiva) throws BackEndException;

    void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID orgId) throws BackEndException;

    OrganizacionDeportivaDTO consultarOrganizacionDeportivaPorId(UUID orgId) throws BackEndException;

    List<OrganizacionDeportivaDTO> consultarOrganizacionesDeportivas(OrganizacionDeportivaDTO filtro) throws BackEndException;

    void aceptarOrganizacion(UUID orgId) throws BackEndException;

    void rechazarOrganizacion(UUID orgId) throws BackEndException;

}
