package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class EncargadoDomain {

    private UUID id;
    private String nombre;
    private OrganizacionDeportivaDomain organizacionDeportiva;

    EncargadoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setOrganizacionDeportiva(OrganizacionDeportivaDomain.obtenerOrganizacionDeportivaDefecto());
    }

    public EncargadoDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setOrganizacionDeportiva(OrganizacionDeportivaDomain.obtenerOrganizacionDeportivaDefecto());
    }

    public EncargadoDomain(final UUID id, final String nombre, OrganizacionDeportivaDomain organizacionDeportiva) {
        setId(id);
        setNombre(nombre);
        setOrganizacionDeportiva(organizacionDeportiva);
    }

    static EncargadoDomain obtenerEncargadoDefecto() {
        return new EncargadoDomain();
    }

    static EncargadoDomain obtenerValorDefecto(EncargadoDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerEncargadoDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
    }

    public OrganizacionDeportivaDomain getOrganizacionDeportiva() {
        return organizacionDeportiva;
    }

    private void setOrganizacionDeportiva(final OrganizacionDeportivaDomain organizacionDeportiva) {
        this.organizacionDeportiva = OrganizacionDeportivaDomain.obtenerValorDefecto(organizacionDeportiva);
    }
}