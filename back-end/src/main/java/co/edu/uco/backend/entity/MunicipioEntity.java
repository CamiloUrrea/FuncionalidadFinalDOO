package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class MunicipioEntity {

    private UUID id;
    private String nombre;
    private DepartamentoEntity departamentoEntity;

    public MunicipioEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamentoEntity(DepartamentoEntity.obtenerDepartamentoDefecto());
    }

    public MunicipioEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamentoEntity(DepartamentoEntity.obtenerDepartamentoDefecto());
    }

    public MunicipioEntity(final UUID id, String nombre, DepartamentoEntity departamentoEntity) {
        setId(id);
        setNombre(nombre);
        setDepartamentoEntity(departamentoEntity);
    }

    public static MunicipioEntity obtenerMunicipioDefecto() {
        return new MunicipioEntity();
    }

    public static MunicipioEntity obtenerValorDefecto(MunicipioEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerMunicipioDefecto());
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

    public DepartamentoEntity getDepartamentoEntity() {
        return departamentoEntity;
    }

    public void setDepartamentoEntity(final DepartamentoEntity departamentoEntity) {
        this.departamentoEntity = DepartamentoEntity.obtenerValorDefecto(departamentoEntity);
    }
}
