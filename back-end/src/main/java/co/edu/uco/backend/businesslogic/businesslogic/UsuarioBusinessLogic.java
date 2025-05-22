package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;

import java.util.UUID;

public interface UsuarioBusinessLogic {
    UsuarioDomain iniciarSesion(String username, String rawPassword);
    void cerrarSesion(UUID usuarioId);// throws SesionException
    void recuperarContrasena(String username);
    void cambiarContrasena(UUID usuarioId, String rawPasswordActual, String rawPasswordNueva);
    UsuarioDomain consultarUsuarioPorId(UUID usuarioId);
}
