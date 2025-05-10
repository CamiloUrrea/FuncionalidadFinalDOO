package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class HorarioDisponibleEntity {

    private UUID id;
    private String nombre;
    private CanchaEntity canchaEntity;
    private DiaSemanaEntity diaSemanaEntity;

    public HorarioDisponibleEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaEntity(CanchaEntity.obtenerCanchaDefecto());
        setDiaSemanaEntity(DiaSemanaEntity.obtenerDiaSemanaDefecto());
    }

    public HorarioDisponibleEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaEntity(CanchaEntity.obtenerCanchaDefecto());
        setDiaSemanaEntity(DiaSemanaEntity.obtenerDiaSemanaDefecto());
    }

    public HorarioDisponibleEntity(final UUID id, String nombre, CanchaEntity canchaEntity, DiaSemanaEntity diaSemanaEntity) {
        setId(id);
        setNombre(nombre);
        setCanchaEntity(canchaEntity);
        setDiaSemanaEntity(diaSemanaEntity);
    }

    public static HorarioDisponibleEntity obtenerHorarioDisponibleDefecto() {
        return new HorarioDisponibleEntity();
    }

    public static HorarioDisponibleEntity obtenerValorDefecto(HorarioDisponibleEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerHorarioDisponibleDefecto());
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
    public DiaSemanaEntity getDiaSemanaEntity() {
        return diaSemanaEntity;
    }

    public void setDiaSemanaEntity(final DiaSemanaEntity diaSemanaEntity) {
        this.diaSemanaEntity = DiaSemanaEntity.obtenerValorDefecto(diaSemanaEntity);
    }
}
