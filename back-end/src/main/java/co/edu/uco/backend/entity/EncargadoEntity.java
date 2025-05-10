package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class EncargadoEntity {

    private UUID id;
    private String nombre;
    private OrganizacionDeportivaEntity organizacionDeportivaEntity;

    public EncargadoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setOrganizacionDeportivaEntity(OrganizacionDeportivaEntity.obtenerOrganizacionDeportivaDefecto());
    }

    public EncargadoEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setOrganizacionDeportivaEntity(OrganizacionDeportivaEntity.obtenerOrganizacionDeportivaDefecto());
    }

    public EncargadoEntity(final UUID id, String nombre, OrganizacionDeportivaEntity organizacionDeportivaEntity) {
        setId(id);
        setNombre(nombre);
        setOrganizacionDeportivaEntity(organizacionDeportivaEntity);
    }

    public static EncargadoEntity obtenerEncargadoDefecto() {
        return new EncargadoEntity();
    }

    public static EncargadoEntity obtenerValorDefecto(EncargadoEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerEncargadoDefecto());
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

    public OrganizacionDeportivaEntity getOrganizacionDeportivaEntity() {
        return organizacionDeportivaEntity;
    }

    public void setOrganizacionDeportivaEntity(final OrganizacionDeportivaEntity organizacionDeportivaEntity) {
        this.organizacionDeportivaEntity = OrganizacionDeportivaEntity.obtenerValorDefecto(organizacionDeportivaEntity);
    }
}
