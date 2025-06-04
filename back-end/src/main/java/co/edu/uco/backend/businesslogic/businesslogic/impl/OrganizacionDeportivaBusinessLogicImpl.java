package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.assembler.estadoverificacion.entity.EstadoVerificacionEntityAssembler;
import co.edu.uco.backend.businesslogic.assembler.organizaciondeportiva.entity.OrganizacionDeportivaEntityAssembler;
import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionDeportivaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.OrganizacionDeportivaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.EstadoVerificacionDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.backend.data.dao.entity.estadoverificacion.EstadoVerificacionDAO;
import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.OrganizacionDeportivaDAO;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.entity.OrganizacionDeportivaEntity;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class OrganizacionDeportivaBusinessLogicImpl implements OrganizacionDeportivaBusinessLogic {

    private final DAOFactory daoFactory;

    /**
     * Prefijos válidos de Latinoamérica (formato E.164).
     */
    private static final Set<String> PREFIJOS_LATINOAMERICANOS = Set.of(
            "+52",   // México
            "+502",  // Guatemala
            "+503",  // El Salvador
            "+504",  // Honduras
            "+505",  // Nicaragua
            "+506",  // Costa Rica
            "+507",  // Panamá
            "+51",   // Perú
            "+54",   // Argentina
            "+55",   // Brasil
            "+56",   // Chile
            "+57",   // Colombia
            "+58",   // Venezuela
            "+591",  // Bolivia
            "+593",  // Ecuador
            "+595",  // Paraguay
            "+597",  // Guyana
            "+598",  // Uruguay
            "+501"   // Belice
    );

    public OrganizacionDeportivaBusinessLogicImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registrarNuevaOrganizacionDeportiva(OrganizacionDeportivaDomain domain) throws BackEndException {
        // 1) Validar campos obligatorios
        if (UtilTexto.getInstance().estaVacia(domain.getNombre())) {
            throw new BackEndException(
                    "El nombre de la organización no puede estar vacío.",
                    "registrarNuevaOrganizacionDeportiva: nombre vacío"
            );
        }
        if (domain.getNombre().length() > 100) {
            throw new BackEndException(
                    "El nombre de la organización no puede exceder 100 caracteres.",
                    "RegistrarOrganizacionDeportiva: nombre demasiado largo;"
            );
        }

        if (UtilTexto.getInstance().estaVacia(domain.getUsername())) {
            throw new BackEndException(
                    "El username no puede estar vacío.",
                    "registrarNuevaOrganizacionDeportiva: username vacío"
            );
        }
        if (domain.getUsername().length() > 50) {
            throw new BackEndException(
                    "El username no puede exceder 50 caracteres.",
                    "RegistrarOrganizacionDeportiva: username demasiado largo;"
            );
        }



        String password = domain.getContrasena();
        if (password == null || password.isEmpty()) {
            throw new BackEndException("La contraseña no puede estar vacía.", "RegistroOrganizacionDeportiva: contraseña vacía");
        }
        if (password.length() > 100) {
            throw new BackEndException(
                    "La contraseña no puede tener mas de 100 carácteres",
                    "RegistroOrganizacionDeportiva: contraseña demasiado larga"
            );
        }
        if (password.length() < 8) {
            throw new BackEndException("La contraseña debe tener al menos 8 caracteres.", "RegistroOrganizacionDeportiva contraseña demasiado corta");
        }
        long countEspeciales = password.chars()
                .filter(c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c))
                .count();
        if (countEspeciales < 3) {
            throw new BackEndException(
                    "La contraseña debe contener al menos 3 caracteres especiales.",
                    "RegistroOrganizacionDeportiva: no hay suficientes caracteres especiales"
            );
        }



        if (UtilTexto.getInstance().estaVacia(domain.getPrefijoTelefono())) {
            throw new BackEndException("El prefijo telefónico no puede estar vacío.", "RegistroOrganizacionDeportiva: Prefijo Vacío");
        }
        if (domain.getPrefijoTelefono().length() > 5) {
            throw new BackEndException(
                    "El prefijo telefónico no puede exceder 5 caracteres.",
                    "RegistroOrganizacionDeportiva: Prefijo demasiado largo;"
            );
        }




        if (UtilTexto.getInstance().estaVacia(domain.getTelefono())) {
            throw new BackEndException("El teléfono no puede estar vacío.", "ResgistroOrganizacionDeportiva: Teléfono vacío");
        }
        if (domain.getTelefono().length() > 10) {
            throw new BackEndException(
                    "El número de teléfono no puede exceder 10 dígitos.",
                    "RegistroOrganizacionDeportiva: Teléfono demasiado largo;"
            );
        }
        if (!domain.getTelefono().matches("\\d{7,10}")) {
            throw new BackEndException(
                    "El número de teléfono no es válido. Debe contener entre 7 y 10 dígitos numéricos.",
                    "RegistroOrganizacionDeportiva: El teléfono no contiene entre 7 y 10 dígitos numéricos"
            );
        }


        if (UtilTexto.getInstance().estaVacia(domain.getDocumentoExistencia())) {
            throw new BackEndException("El RUT no puede estar vacío.", "RegistroOrganizacionDeportiva: El Rut está vacío");
        }
        if (domain.getDocumentoExistencia().length() > 12) {
            throw new BackEndException(
                    "El RUT no puede exceder 12 caracteres.",
                    "RegistroOrganizacionDeportiva: El Rut es demasiado largo"
            );
        }
        // Ya tenías tu validación de patrón con guión...
        if (domain.getDocumentoExistencia().length() < 7 ||
                !domain.getDocumentoExistencia().matches("[0-9]+[-][0-9Kk]"))
        {
            throw new BackEndException(
                    "El formato del RUT no es válido. Ej: 12345678-9.",
                    "RegistroOrganizacionDeportiva: El Rut ingresado no sumple con el formato indicado"
            );
        }

        if (UtilTexto.getInstance().estaVacia(domain.getCorreoAdministrativo())) {
            throw new BackEndException("El correo administrativo no puede estar vacío.", "RegistroOrganizacionDeportiva: Correo Administrativo Vacío");
        }
        if (domain.getCorreoAdministrativo().length() > 100) {
            throw new BackEndException(
                    "El correo administrativo no puede exceder 100 caracteres.",
                    "RegistroOrganizacionDeportiva: Correo Administrativo demasiado largo;"
            );
        }
        String correo = domain.getCorreoAdministrativo();
        // Regex muy sencillo: “texto@texto.dominio” sin espacios
        if (!correo.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new BackEndException(
                    "El correo administrativo no tiene un formato válido (ej: usuario@dominio.com).",
                    "RegsitroOrganizacionDeportiva: El correo no cumple con un formato válido"
            );
        }

        if (domain.getPaginaWeb() != null && domain.getPaginaWeb().length() > 200) {
            throw new BackEndException(
                    "La URL de la página web no puede exceder 200 caracteres.",
                    "RegistroOrganizacionDeportiva: PaginaWeb demasiado larga"
            );
        }

        String pagina = domain.getPaginaWeb();
        if (pagina != null && !pagina.isBlank()) {
            // Debe empezar con http:// o https:// y luego al menos un carácter
            if (!pagina.matches("^(https?://).+")) {
                throw new BackEndException(
                        "La URL de la página web no es válida. Debe iniciar con http:// o https://",
                        "RegistroOrganizacionDeportiva: La RUL de la pagina web no cumple con el formato indicado"
                );
            }
        }

        String prefijo = domain.getPrefijoTelefono().trim();
        if (!PREFIJOS_LATINOAMERICANOS.contains(prefijo)) {
            throw new BackEndException(
                    "El prefijo telefónico '" + prefijo + "' no es válido. Debe ser uno de: " + PREFIJOS_LATINOAMERICANOS,
                    "registrarNuevaOrganizacionDeportiva: prefijo inválido"
            );
        }

        OrganizacionDeportivaDAO orgDao = daoFactory.getOrganizacionDeportivaDAO();
        if (orgDao.existsByUsername(domain.getUsername().trim())) {
            throw new BackEndException(
                    "El username ya está en uso.",
                    "registrarNuevaOrganizacionDeportiva: username duplicado"
            );
        }

        if (orgDao.existsByRut(domain.getDocumentoExistencia().trim())) {
            throw new BackEndException(
                    "El RUT ya se encuentra registrado.",
                    "registrarNuevaOrganizacionDeportiva: RUT duplicado"
            );
        }


        if (UtilUUID.esValorDefecto(domain.getId())) {
            domain.setId(UtilUUID.generarNuevoUUID());
        }

        EstadoVerificacionDAO estadoDao = daoFactory.getEstadoVerificacionDAO();
        UUID pendienteId = estadoDao
                .findIdByNombre("Pendiente")
                .orElseThrow(() -> new BackEndException(
                        "Estado 'Pendiente' no existe en la base de datos.",
                        "registrarNuevaOrganizacionDeportiva: estado Pendiente no encontrado"
                ));
        domain.setEstadoVerificacion(new EstadoVerificacionDomain(pendienteId, null));

        OrganizacionDeportivaEntity entity = OrganizacionDeportivaEntityAssembler
                .getInstance()
                .toEntity(domain);

        orgDao.crear(entity);
    }

    @Override
    public void modificarOrganizacionDeportivaExistente(UUID orgId, OrganizacionDeportivaDomain organizacionDeportiva) throws BackEndException {
        throw new UnsupportedOperationException("Aún no implementado.");
    }

    @Override
    public void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID orgId) throws BackEndException {
        throw new UnsupportedOperationException("Aún no implementado.");
    }

    @Override
    public OrganizacionDeportivaDomain consultarOrganizacionDeportivaPorId(UUID orgId) throws BackEndException {
        throw new UnsupportedOperationException("Aún no implementado.");
    }

    @Override
    public List<OrganizacionDeportivaDomain> consultarOrganizacionesDeportivas(OrganizacionDeportivaDomain filtro) throws BackEndException {
        throw new UnsupportedOperationException("Aún no implementado.");
    }

    @Override
    public void aceptarOrganizacion(UUID orgId) throws BackEndException {
        throw new UnsupportedOperationException("Aún no implementado.");
    }

    @Override
    public void rechazarOrganizacion(UUID orgId) throws BackEndException {
        throw new UnsupportedOperationException("Aún no implementado.");
    }

    // Métodos heredados de UsuarioBusinessLogic (por contrato, deben existir aquí)
    @Override
    public UsuarioDomain iniciarSesion(String username, String rawPassword, String ipAdress, String userAgent) throws BackEndException {
        // 1) Obtenemos la entidad desde el DAO
        OrganizacionDeportivaDAO orgDao = daoFactory.getOrganizacionDeportivaDAO();
        var optEntity = orgDao.consultarPorUsername(username.trim());
        if (optEntity.isEmpty()) {
            throw new BackEndException(
                    "Usuario o contraseña incorrectos.",
                    "iniciarSesion: username no encontrado"
            );
        }
        var entidad = optEntity.get();

        // 2) Verificamos la contraseña (texto plano). Si usas hashing, reemplaza con passwordEncoder.matches(...)
        if (!entidad.getContrasena().equals(rawPassword)) {
            throw new BackEndException(
                    "Usuario o contraseña incorrectos.",
                    "iniciarSesion: password inválida"
            );
        }

        // 3) Verificamos el estado “Verificado”
        var estadoEntity = entidad.getEstadoVerificacion();
        var estadoDomain = EstadoVerificacionEntityAssembler.getInstance().toDomain(estadoEntity);
        if (!"Verificado".equalsIgnoreCase(estadoDomain.getNombre())) {
            throw new BackEndException(
                    "Cuenta aún no está verificada.",
                    "iniciarSesion: estado no verificado"
            );
        }

        // 4) Construimos y devolvemos el Domain de la organización
        return new OrganizacionDeportivaDomain(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getUsername(),
                entidad.getContrasena(),
                entidad.getPrefijoTelefono(),
                entidad.getTelefono(),
                entidad.getDocumentoExistencia(),
                entidad.getCorreoAdministrativo(),
                entidad.getPaginaWeb(),
                new EstadoVerificacionDomain(estadoDomain.getId(), estadoDomain.getNombre())
        );
    }

    @Override
    public void cerrarSesion(UUID usuarioId) {
        throw new UnsupportedOperationException("No implementado en esta clase.");
    }

    @Override
    public void recuperarContrasena(String username) {
        throw new UnsupportedOperationException("No implementado en esta clase.");
    }

    @Override
    public void cambiarContrasena(UUID usuarioId, String rawPasswordActual, String rawPasswordNueva) {
        throw new UnsupportedOperationException("No implementado en esta clase.");
    }

    @Override
    public UsuarioDomain consultarUsuarioPorId(UUID usuarioId) {
        throw new UnsupportedOperationException("No implementado en esta clase.");
    }

    @Override
    public List<UsuarioDomain> listarUsuarios(UsuarioDomain filtro) {
        throw new UnsupportedOperationException("No implementado en esta clase.");
    }
}

