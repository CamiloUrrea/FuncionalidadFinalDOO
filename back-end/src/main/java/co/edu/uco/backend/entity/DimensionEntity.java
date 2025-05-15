package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;

import java.util.UUID;

public final class DimensionEntity {

    private UUID id;
    private String nombre;

    public DimensionEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public DimensionEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public DimensionEntity(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static DimensionEntity obtenerDimensionDefecto() {
        return new DimensionEntity();
    }

    public static DimensionEntity obtenerValorDefecto(final DimensionEntity entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerDimensionDefecto());
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
}
