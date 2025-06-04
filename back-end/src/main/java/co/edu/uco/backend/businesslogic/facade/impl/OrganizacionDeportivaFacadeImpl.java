package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.assembler.organizaciondeportiva.dto.OrganizacionDeportivaDTOAssembler;
import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionDeportivaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.OrganizacionDeportivaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.backend.businesslogic.businesslogic.impl.OrganizacionDeportivaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.facade.OrganizacionDeportivaFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.BusinessLogicBackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.OrganizacionDeportivaDTO;
import co.edu.uco.backend.dto.UsuarioDTO;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizacionDeportivaFacadeImpl implements OrganizacionDeportivaFacade {

    private final DAOFactory daoFactory;
    private final OrganizacionDeportivaBusinessLogic organizacionDeportivaBusinessLogic;

    public OrganizacionDeportivaFacadeImpl() throws BackEndException {
        this.daoFactory = DAOFactory.getFactory(Factory.POSTGRE_SQL);
        this.organizacionDeportivaBusinessLogic = new OrganizacionDeportivaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevaOrganizacionDeportiva(OrganizacionDeportivaDTO organizacionDeportiva) throws BackEndException {
        try {
            // 1) Abrir conexión ANTES de iniciar transacción
            daoFactory.abrirConexion();
            // 2) Iniciar transacción
            daoFactory.iniciarTransaccion();

            // 3) Convertir DTO → Domain
            OrganizacionDeportivaDomain organizacionDeportivaDomain =
                    OrganizacionDeportivaDTOAssembler.getInstance().toDomain(organizacionDeportiva);

            // 4) Llamar a la lógica de negocio
            organizacionDeportivaBusinessLogic.registrarNuevaOrganizacionDeportiva(organizacionDeportivaDomain);

            // 5) Confirmar transacción
            daoFactory.confirmarTransaccion();

        } catch (BackEndException exception) {
            // En caso de validación/controlada: hacer rollback
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) {
                // Si el rollback falla, lo ignoramos para poder re-lanzar la excepción original
            }
            throw exception;

        } catch (Exception exception) {
            // Cualquiera que no sea BackEndException: rollback y relanzar con BusinessLogicBackEndException
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) {
            }
            var mensajeTecnico = "Se presentó una excepción inesperada de tipo Exception " +
                    "tratando de registrar la información de la nueva organización deportiva, " +
                    "para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de " +
                    "registrar la información de la nueva organización deportiva";

            throw BusinessLogicBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        // NOTA: NO cerramos la conexión aquí. Dejamos abierta hasta que el bean se destruya.
    }

    @Override
    public void modificarOrganizacionDeportivaExistente(UUID orgId, OrganizacionDeportivaDTO organizacionDeportiva) throws BackEndException {
        try {
            daoFactory.abrirConexion();
            daoFactory.iniciarTransaccion();

            // Convertir DTO → Domain
            var organizacionDeportivaDomain =
                    OrganizacionDeportivaDTOAssembler.getInstance().toDomain(organizacionDeportiva);

            organizacionDeportivaBusinessLogic.modificarOrganizacionDeportivaExistente(orgId, organizacionDeportivaDomain);

            daoFactory.confirmarTransaccion();

        } catch (BackEndException exception) {
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) {
            }
            throw exception;

        } catch (Exception exception) {
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) {
            }
            var mensajeTecnico = "Se presentó una excepción inesperada de tipo Exception " +
                    "tratando de modificar la información de la organización deportiva, " +
                    "para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de " +
                    "modificar la información de la organización deportiva";

            throw BusinessLogicBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID orgId) throws BackEndException {
        try {
            daoFactory.abrirConexion();
            daoFactory.iniciarTransaccion();

            organizacionDeportivaBusinessLogic.darBajaDefinitivamenteOrganizacionDeportivaExistente(orgId);

            daoFactory.confirmarTransaccion();

        } catch (BackEndException exception) {
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) {
            }
            throw exception;

        } catch (Exception exception) {
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) {
            }
            var mensajeTecnico = "Se presentó una excepción inesperada de tipo Exception " +
                    "tratando de dar baja definitiva de la organización deportiva, " +
                    "para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de " +
                    "dar baja definitiva de la organización deportiva";

            throw BusinessLogicBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public OrganizacionDeportivaDTO consultarOrganizacionDeportivaPorId(UUID orgId) throws BackEndException {
        try {
            daoFactory.abrirConexion();
            // No hay cambio en transacción, sólo lectura
            var organizacionDeportivaDomainResultado =
                    organizacionDeportivaBusinessLogic.consultarOrganizacionDeportivaPorId(orgId);
            // Convertir Domain → DTO
            return OrganizacionDeportivaDTOAssembler.getInstance().toDTO(organizacionDeportivaDomainResultado);

        } catch (BackEndException exception) {
            throw exception;
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción inesperada de tipo Exception " +
                    "tratando de consultar la información de la organización deportiva con el identificador deseado, " +
                    "para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar " +
                    "la información de la organización deportiva con el identificador deseado";

            throw BusinessLogicBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<OrganizacionDeportivaDTO> consultarOrganizacionesDeportivas(OrganizacionDeportivaDTO filtro) throws BackEndException {
        try {
            daoFactory.abrirConexion();
            // Convertir DTO(filtro) → Domain
            var filtroDomain = OrganizacionDeportivaDTOAssembler.getInstance().toDomain(filtro);
            // Consultar lista de Domains
            var dominios = organizacionDeportivaBusinessLogic.consultarOrganizacionesDeportivas(filtroDomain);
            // Convertir List<Domain> → List<DTO>
            return dominios.stream()
                    .map(OrganizacionDeportivaDTOAssembler.getInstance()::toDTO)
                    .toList();

        } catch (BackEndException exception) {
            throw exception;
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema inesperado al consultar todas las organizaciones deportivas";
            var mensajeTecnico = "Excepción inesperada listando todas las organizaciones deportivas";
            throw BusinessLogicBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void aceptarOrganizacion(UUID orgId) throws BackEndException {
        try {
            daoFactory.abrirConexion();
            daoFactory.iniciarTransaccion();

            organizacionDeportivaBusinessLogic.aceptarOrganizacion(orgId);

            daoFactory.confirmarTransaccion();

        } catch (BackEndException exception) {
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) { }
            throw exception;
        } catch (Exception exception) {
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) { }
            var mensajeTecnico = "Se presentó una excepción inesperada de tipo Exception " +
                    "tratando de aceptar la organización deportiva, " +
                    "para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado al aceptar la organización deportiva";
            throw BusinessLogicBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void rechazarOrganizacion(UUID orgId) throws BackEndException {
        try {
            daoFactory.abrirConexion();
            daoFactory.iniciarTransaccion();

            organizacionDeportivaBusinessLogic.rechazarOrganizacion(orgId);

            daoFactory.confirmarTransaccion();

        } catch (BackEndException exception) {
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) { }
            throw exception;
        } catch (Exception exception) {
            try {
                daoFactory.cancelarTransaccion();
            } catch (Exception ignore) { }
            var mensajeTecnico = "Se presentó una excepción inesperada de tipo Exception " +
                    "tratando de rechazar la organización deportiva, " +
                    "para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado al rechazar la organización deportiva";
            throw BusinessLogicBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    // ——— Métodos de Usuario ———

    @Override
    public UsuarioDTO iniciarSesion(String username, String password, String ip, String userAgent) throws BackEndException {
        daoFactory.abrirConexion();
        UsuarioDomain usuarioDomain = organizacionDeportivaBusinessLogic.iniciarSesion(username, password, ip, userAgent);

        // 2) Convertimos Domain → DTO (sin incluir datos sensibles)
        UsuarioDTO usuarioDto = new UsuarioDTO();
        usuarioDto.setId(usuarioDomain.getId());
        usuarioDto.setNombre(usuarioDomain.getNombre());
        usuarioDto.setUsername(usuarioDomain.getUsername());
        return usuarioDto;
    }

    @Override
    public void cerrarSesion(UUID usuarioId) {
        // No implementado
    }

    @Override
    public void recuperarContrasena(String username) {
        // No implementado
    }

    @Override
    public void cambiarContrasena(UUID usuarioId, String rawPasswordActual, String rawPasswordNueva) {
        // No implementado
    }

    @Override
    public UsuarioDTO consultarUsuarioPorId(UUID usuarioId) {
        // No implementado
        return null;
    }

    @Override
    public List<UsuarioDTO> listarUsuarios(UsuarioDTO filtro) {
        // No implementado
        return List.of();
    }

    @PreDestroy
    private void cerrarConexiones() throws BackEndException {
        if (daoFactory != null) {
            daoFactory.cerrarConexion();
        }
    }
}

