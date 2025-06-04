package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.OrganizacionDeportivaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;

import java.util.List;
import java.util.UUID;

public interface OrganizacionDeportivaBusinessLogic extends UsuarioBusinessLogic {

    /**
     * Registra una nueva organización deportiva. La implementación deberá:
     *  1. Validar campos obligatorios (nombre, username, contraseña, prefijo, teléfono, RUT).
     *  2. Verificar unicidad de username y RUT.
     *  3. Validar formato de RUT.
     *  4. Validar prefijo y número de teléfono contra lista de prefijos reales.
     *  5. Validar que la contraseña tenga mínimo 8 caracteres y al menos 3 caracteres especiales,
     *     permitiendo espacios al inicio y al final.
     *  6. Generar UUID si no viene en el dominio.
     *  7. Asignar automáticamente el estado “Pendiente” llamando a EstadoVerificacionDAO.
     *  8. Convertir Domain → Entity y delegar a OrganizacionDeportivaDAO para insertar en BD.
     *
     * @param organizacionDeportiva Objeto de dominio con todos los datos requeridos.
     * @throws BackEndException Si ocurre cualquier error en la capa de persistencia o en la obtención del UUID de estado.
     */
    void registrarNuevaOrganizacionDeportiva(OrganizacionDeportivaDomain organizacionDeportiva) throws BackEndException;


    @Override
    UsuarioDomain iniciarSesion(String username, String rawPassword, String ipAdress, String userAgent) throws BackEndException;

    /**
     * Modifica los datos de una organización deportiva ya existente.
     *
     * @param orgId     UUID de la organización que se va a modificar.
     * @param organizacionDeportiva Nuevos datos en forma de dominio.
     * @throws BackEndException Si ocurre algún error en la capa de persistencia.
     */
    void modificarOrganizacionDeportivaExistente(UUID orgId, OrganizacionDeportivaDomain organizacionDeportiva) throws BackEndException;

    /**
     * Elimina de forma definitiva una organización deportiva.
     *
     * @param orgId UUID de la organización a eliminar.
     * @throws BackEndException Si ocurre algún error en la capa de persistencia.
     */
    void darBajaDefinitivamenteOrganizacionDeportivaExistente(UUID orgId) throws BackEndException;

    /**
     * Consulta una organización deportiva por su UUID.
     *
     * @param orgId UUID de la organización a buscar.
     * @return Objeto de dominio con los datos encontrados, o null si no existe.
     * @throws BackEndException Si ocurre algún error en la capa de persistencia.
     */
    OrganizacionDeportivaDomain consultarOrganizacionDeportivaPorId(UUID orgId) throws BackEndException;

    /**
     * Consulta todas (o según filtro) las organizaciones deportivas.
     *
     * @param filtro Objeto de dominio que puede traer campos para filtrar la búsqueda.
     * @return Lista de dominios con las organizaciones que coincidan.
     * @throws BackEndException Si ocurre algún error en la capa de persistencia.
     */
    List<OrganizacionDeportivaDomain> consultarOrganizacionesDeportivas(OrganizacionDeportivaDomain filtro) throws BackEndException;

    /**
     * Cambia el estado de una organización a “Verificado”.
     *
     * @param orgId UUID de la organización a aceptar.
     * @throws BackEndException Si ocurre algún error en la capa de persistencia.
     */
    void aceptarOrganizacion(UUID orgId) throws BackEndException;

    /**
     * Cambia el estado de una organización a “Rechazado”.
     *
     * @param orgId UUID de la organización a rechazar.
     * @throws BackEndException Si ocurre algún error en la capa de persistencia.
     */
    void rechazarOrganizacion(UUID orgId) throws BackEndException;

}
