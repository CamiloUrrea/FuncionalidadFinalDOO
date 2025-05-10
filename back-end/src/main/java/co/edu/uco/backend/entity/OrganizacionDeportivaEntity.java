package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class OrganizacionDeportivaEntity {

    private UUID id;
    private String nombre;
    private EstadoVerificacionEntity estadoVerificacionEntity;

    public OrganizacionDeportivaEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setEstadoVerificacionEntity(EstadoVerificacionEntity.obtenerEstadoVerificacionDefecto());
    }

    public OrganizacionDeportivaEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setEstadoVerificacionEntity(EstadoVerificacionEntity.obtenerEstadoVerificacionDefecto());
    }

    public OrganizacionDeportivaEntity(final UUID id, String nombre, EstadoVerificacionEntity estadoVerificacionEntity) {
        setId(id);
        setNombre(nombre);
        setEstadoVerificacionEntity(estadoVerificacionEntity);
    }

    public static OrganizacionDeportivaEntity obtenerOrganizacionDeportivaDefecto() {
        return new OrganizacionDeportivaEntity();
    }

    public static OrganizacionDeportivaEntity obtenerValorDefecto(OrganizacionDeportivaEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerOrganizacionDeportivaDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().obtenerValorDefecto(nombre);
    }

    public EstadoVerificacionEntity getEstadoVerificacionEntity() {
        return estadoVerificacionEntity;
    }

    public void setEstadoVerificacionEntity(final EstadoVerificacionEntity estadoVerificacionEntity) {
        this.estadoVerificacionEntity = EstadoVerificacionEntity.obtenerValorDefecto(estadoVerificacionEntity);
    }
}
