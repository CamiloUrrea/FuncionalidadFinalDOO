package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class HorarioEspecialEntity {

    private UUID id;
    private String nombre;
    private CanchaEntity canchaEntity;

    public HorarioEspecialEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaEntity(CanchaEntity.obtenerCanchaDefecto());
    }

    public HorarioEspecialEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaEntity(CanchaEntity.obtenerCanchaDefecto());
    }

    public HorarioEspecialEntity(final UUID id, String nombre, CanchaEntity canchaEntity) {
        setId(id);
        setNombre(nombre);
        setCanchaEntity(canchaEntity);
    }

    public static HorarioEspecialEntity obtenerHorarioEspecialDefecto() {
        return new HorarioEspecialEntity();
    }

    public static HorarioEspecialEntity obtenerValorDefecto(HorarioEspecialEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerHorarioEspecialDefecto());
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

    public CanchaEntity getCanchaEntity() {
        return canchaEntity;
    }

    public void setCanchaEntity(final CanchaEntity canchaEntity) {
        this.canchaEntity = CanchaEntity.obtenerValorDefecto(canchaEntity);
    }
}
