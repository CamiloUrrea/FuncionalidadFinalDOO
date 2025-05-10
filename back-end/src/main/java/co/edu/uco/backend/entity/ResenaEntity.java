package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class ResenaEntity {

    private UUID id;
    private String nombre;
    private ReservaEntity reservaEntity;

    public ResenaEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setReservaEntity(ReservaEntity.obtenerReservaDefecto());
    }

    public ResenaEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setReservaEntity(ReservaEntity.obtenerReservaDefecto());
    }

    public ResenaEntity(final UUID id, String nombre, ReservaEntity reservaEntity) {
        setId(id);
        setNombre(nombre);
        setReservaEntity(reservaEntity);
    }

    public static ResenaEntity obtenerResenaDefecto() {
        return new ResenaEntity();
    }

    public static ResenaEntity obtenerValorDefecto(ResenaEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerResenaDefecto());
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

    public ReservaEntity getReservaEntity() {
        return reservaEntity;
    }

    public void setReservaEntity(final ReservaEntity reservaEntity) {
        this.reservaEntity = ReservaEntity.obtenerValorDefecto(reservaEntity);
    }
}
