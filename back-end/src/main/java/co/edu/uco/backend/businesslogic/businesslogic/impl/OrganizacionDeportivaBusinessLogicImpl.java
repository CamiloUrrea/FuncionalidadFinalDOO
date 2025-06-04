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



        if (domain.getContrasena() == null || domain.getContrasena().isEmpty()) {
            throw new BackEndException(
                    "La contraseña no puede estar vacía.",
                    "registrarNuevaOrganizacionDeportiva: contraseña vacía"
            );
        }



        if (UtilTexto.getInstance().estaVacia(domain.getPrefijoTelefono())) {
            throw new BackEndException(
                    "El prefijo telefónico no puede estar vacío.",
                    "registrarNuevaOrganizacionDeportiva: prefijo vacío"
            );
        }
        if (UtilTexto.getInstance().estaVacia(domain.getTelefono())) {
            throw new BackEndException(
                    "El teléfono no puede estar vacío.",
                    "registrarNuevaOrganizacionDeportiva: teléfono vacío"
            );
        }
        if (UtilTexto.getInstance().estaVacia(domain.getDocumentoExistencia())) {
            throw new BackEndException(
                    "El RUT no puede estar vacío.",
                    "registrarNuevaOrganizacionDeportiva: RUT vacío"
            );
        }

        // 2) Validar que el prefijo pertenezca a Latinoamérica
        String prefijo = domain.getPrefijoTelefono().trim();
        if (!PREFIJOS_LATINOAMERICANOS.contains(prefijo)) {
            throw new BackEndException(
                    "El prefijo telefónico '" + prefijo + "' no es válido. Debe ser uno de: " + PREFIJOS_LATINOAMERICANOS,
                    "registrarNuevaOrganizacionDeportiva: prefijo inválido"
            );
        }

        // 3) Validar número de teléfono: solo dígitos, longitud de 7 a 10 caracteres
        String telefono = domain.getTelefono().trim();
        if (!telefono.matches("\\d{7,10}")) {
            throw new BackEndException(
                    "El número de teléfono no es válido. Debe contener entre 7 y 10 dígitos numéricos.",
                    "registrarNuevaOrganizacionDeportiva: formato de teléfono inválido"
            );
        }

        // 4) Validar unicidad de username y RUT
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

        // 5) Validación mínima de formato de RUT (al menos 7 caracteres y un guión)
        String rut = domain.getDocumentoExistencia().trim();
        if (rut.length() < 7 || !rut.matches("[0-9]+[-][0-9Kk]")) {
            throw new BackEndException(
                    "El formato del RUT no es válido. Debe seguir el patrón numérico con guión y dígito verificador. Ej: 12345678-9.",
                    "registrarNuevaOrganizacionDeportiva: formato de RUT inválido"
            );
        }

        // 6) Validar contraseña: mínimo 8 caracteres, al menos 3 caracteres especiales
        String password = domain.getContrasena();
        if (password.length() < 8) {
            throw new BackEndException(
                    "La contraseña debe tener al menos 8 caracteres.",
                    "registrarNuevaOrganizacionDeportiva: contraseña demasiado corta"
            );
        }
        long countEspeciales = password.chars()
                .filter(c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c))
                .count();
        if (countEspeciales < 3) {
            throw new BackEndException(
                    "La contraseña debe contener al menos 3 caracteres especiales (por ejemplo: ! @ # $ % & *).",
                    "registrarNuevaOrganizacionDeportiva: no hay suficientes caracteres especiales"
            );
        }
        // No aplicamos trim() a la contraseña para permitir espacios al inicio/fin

        // 7) Generar UUID si no viene en el domain
        if (UtilUUID.esValorDefecto(domain.getId())) {
            domain.setId(UtilUUID.generarNuevoUUID());
        }

        // 8) Obtener el estado “Pendiente”
        EstadoVerificacionDAO estadoDao = daoFactory.getEstadoVerificacionDAO();
        UUID pendienteId = estadoDao
                .findIdByNombre("Pendiente")
                .orElseThrow(() -> new BackEndException(
                        "Estado 'Pendiente' no existe en la base de datos.",
                        "registrarNuevaOrganizacionDeportiva: estado Pendiente no encontrado"
                ));
        domain.setEstadoVerificacion(new EstadoVerificacionDomain(pendienteId, null));

        // 9) Convertir Domain → Entity
        OrganizacionDeportivaEntity entity = OrganizacionDeportivaEntityAssembler
                .getInstance()
                .toEntity(domain);

        // 10) Persistir con el DAO
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

