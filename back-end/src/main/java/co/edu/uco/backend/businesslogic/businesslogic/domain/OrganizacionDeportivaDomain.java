package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class OrganizacionDeportivaDomain {

    private UUID id;
    private String nombre;
    private EstadoVerificacionDomain estadoVerificacion;

    OrganizacionDeportivaDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setEstadoVerificacion(EstadoVerificacionDomain.obtenerEstadoVerificacionDefecto());
    }

    public OrganizacionDeportivaDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setEstadoVerificacion(EstadoVerificacionDomain.obtenerEstadoVerificacionDefecto());
    }

    public OrganizacionDeportivaDomain(final UUID id, final String nombre, EstadoVerificacionDomain estadoVerificacion) {
        setId(id);
        setNombre(nombre);
        setEstadoVerificacion(estadoVerificacion);
    }

    static OrganizacionDeportivaDomain obtenerOrganizacionDeportivaDefecto() {
        return new OrganizacionDeportivaDomain();
    }

    static OrganizacionDeportivaDomain obtenerValorDefecto(OrganizacionDeportivaDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerOrganizacionDeportivaDefecto());
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

    public EstadoVerificacionDomain getEstadoVerificacion() {
        return estadoVerificacion;
    }

    private void setEstadoVerificacion(final EstadoVerificacionDomain estadoVerificacion) {
        this.estadoVerificacion = EstadoVerificacionDomain.obtenerValorDefecto(estadoVerificacion);
    }
}