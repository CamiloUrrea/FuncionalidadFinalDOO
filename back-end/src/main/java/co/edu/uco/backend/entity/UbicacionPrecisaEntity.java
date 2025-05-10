package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class UbicacionPrecisaEntity {

    private UUID id;
    private String nombre;
    private MunicipioEntity municipioEntity;

    public UbicacionPrecisaEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMunicipioEntity(MunicipioEntity.obtenerMunicipioDefecto());
    }

    public UbicacionPrecisaEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMunicipioEntity(MunicipioEntity.obtenerMunicipioDefecto());
    }

    public UbicacionPrecisaEntity(final UUID id, String nombre, MunicipioEntity municipioEntity) {
        setId(id);
        setNombre(nombre);
        setMunicipioEntity(municipioEntity);
    }

    public static UbicacionPrecisaEntity obtenerUbicacionPrecisaDefecto() {
        return new UbicacionPrecisaEntity();
    }

    public static UbicacionPrecisaEntity obtenerValorDefecto(UbicacionPrecisaEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerUbicacionPrecisaDefecto());
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

    public MunicipioEntity getMunicipioEntity() {
        return municipioEntity;
    }

    public void setMunicipioEntity(final MunicipioEntity municipioEntity) {
        this.municipioEntity = MunicipioEntity.obtenerValorDefecto(municipioEntity);
    }
}
