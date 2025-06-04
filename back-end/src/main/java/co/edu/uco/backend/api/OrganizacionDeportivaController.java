package co.edu.uco.backend.api;

import co.edu.uco.backend.businesslogic.facade.OrganizacionDeportivaFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.dto.OrganizacionDeportivaDTO;
import co.edu.uco.backend.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/organizaciones")

public class OrganizacionDeportivaController {

    private final OrganizacionDeportivaFacade organizacionDeportivaFacade;

    public OrganizacionDeportivaController(OrganizacionDeportivaFacade organizacionDeportivaFacade) {
        this.organizacionDeportivaFacade = organizacionDeportivaFacade;
    }

    @GetMapping("/dummy")
    public OrganizacionDeportivaDTO dummy() {
        return new OrganizacionDeportivaDTO();
    }

    @PostMapping
    public ResponseEntity<ApiResponse> registrar(@RequestBody OrganizacionDeportivaDTO dto) {
        try {
            organizacionDeportivaFacade.registrarNuevaOrganizacionDeportiva(dto);
            var response = new ApiResponse(
                    HttpStatus.CREATED.value(),
                    "Organización deportiva registrada exitosamente.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (BackEndException ex) {
            String userMsg = ex.getMessage();
            if (userMsg == null || userMsg.isBlank()) {
                userMsg = "Error de validación: revisa los datos enviados.";
            }
            var response = new ApiResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    userMsg,
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Ocurrió un error inesperado al registrar la organización.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{orgId}")
    public ResponseEntity<ApiResponse> modificar(@PathVariable UUID orgId,
                                                 @RequestBody OrganizacionDeportivaDTO dto) {
        try {
            organizacionDeportivaFacade.modificarOrganizacionDeportivaExistente(orgId, dto);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Organización deportiva modificada exitosamente.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (BackEndException ex) {
            String userMsg = ex.getMessage();
            if (userMsg == null || userMsg.isBlank()) {
                userMsg = "Error de validación: revisa los datos enviados.";
            }
            var response = new ApiResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    userMsg,
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al modificar la organización.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{orgId}")
    public ResponseEntity<ApiResponse> eliminar(@PathVariable UUID orgId) {
        try {
            organizacionDeportivaFacade.darBajaDefinitivamenteOrganizacionDeportivaExistente(orgId);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Organización deportiva eliminada exitosamente.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (BackEndException ex) {
            String userMsg = ex.getMessage();
            if (userMsg == null || userMsg.isBlank()) {
                userMsg = "Error de validación: revisa los datos enviados.";
            }
            var response = new ApiResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    userMsg,
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al eliminar la organización.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<ApiResponse> consultarPorId(@PathVariable UUID orgId) {
        try {
            OrganizacionDeportivaDTO dto = organizacionDeportivaFacade.consultarOrganizacionDeportivaPorId(orgId);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "OK",
                    dto
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (BackEndException ex) {
            String userMsg = ex.getMessage();
            if (userMsg == null || userMsg.isBlank()) {
                userMsg = "Error de validación: revisa el identificador proporcionado.";
            }
            var response = new ApiResponse(
                    HttpStatus.NOT_FOUND.value(),
                    userMsg,
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al consultar la organización.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse> listar() {
        try {
            List<OrganizacionDeportivaDTO> lista = organizacionDeportivaFacade.consultarOrganizacionesDeportivas(dummy());
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "OK",
                    lista
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (BackEndException ex) {
            String userMsg = ex.getMessage();
            if (userMsg == null || userMsg.isBlank()) {
                userMsg = "Error de validación: revisa los filtros enviados.";
            }
            var response = new ApiResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    userMsg,
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al listar las organizaciones.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{orgId}/aceptar")
    public ResponseEntity<ApiResponse> aceptar(@PathVariable UUID orgId) {
        try {
            organizacionDeportivaFacade.aceptarOrganizacion(orgId);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Organización aceptada correctamente.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al aceptar la organización.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{orgId}/rechazar")
    public ResponseEntity<ApiResponse> rechazar(@PathVariable UUID orgId) {
        try {
            organizacionDeportivaFacade.rechazarOrganizacion(orgId);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Organización rechazada correctamente.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al rechazar la organización.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<ApiResponse> iniciarSesion(@RequestParam String username,
                                                     @RequestParam String password,
                                                     @RequestParam String ip,
                                                     @RequestParam String userAgent) {
        try {
            UsuarioDTO usuario = organizacionDeportivaFacade.iniciarSesion(username, password, ip, userAgent);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Login exitoso.",
                    usuario
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BackEndException ex) {
            // Error de validación: usuario no encontrado, contraseña inválida o cuenta no verificada
            var response = new ApiResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    ex.getMensajeUsuario(), // aseguramos que sea el mensaje para el usuario
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al iniciar sesión.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/cerrar-sesion/{usuarioId}")
    public ResponseEntity<ApiResponse> cerrarSesion(@PathVariable UUID usuarioId) {
        try {
            organizacionDeportivaFacade.cerrarSesion(usuarioId);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Sesión cerrada correctamente.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al cerrar sesión.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/recuperar-contrasena")
    public ResponseEntity<ApiResponse> recuperarContrasena(@RequestParam String username) {
        try {
            organizacionDeportivaFacade.recuperarContrasena(username);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Correo de recuperación enviado.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al recuperar contraseña.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cambiar-contrasena/{usuarioId}")
    public ResponseEntity<ApiResponse> cambiarContrasena(@PathVariable UUID usuarioId,
                                                         @RequestParam String actual,
                                                         @RequestParam String nueva) {
        try {
            organizacionDeportivaFacade.cambiarContrasena(usuarioId, actual, nueva);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "Contraseña cambiada correctamente.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al cambiar contraseña.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<ApiResponse> consultarUsuario(@PathVariable UUID usuarioId) {
        try {
            UsuarioDTO usuario = organizacionDeportivaFacade.consultarUsuarioPorId(usuarioId);
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "OK",
                    usuario
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al consultar usuario.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<ApiResponse> listarUsuarios() {
        try {
            List<UsuarioDTO> usuarios = organizacionDeportivaFacade.listarUsuarios(new UsuarioDTO());
            var response = new ApiResponse(
                    HttpStatus.OK.value(),
                    "OK",
                    usuarios
            );
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex) {
            var response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error inesperado al listar usuarios.",
                    null
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
