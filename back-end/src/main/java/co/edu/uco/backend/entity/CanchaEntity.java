package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.math.BigDecimal;
import java.util.UUID;

public final class CanchaEntity {

    private UUID id;
    private String nombre;
    private UbicacionPrecisaEntity ubicacionPrecisaEntity;
    private TipoCanchaEntity tipoCanchaEntity;
    private OrganizacionDeportivaEntity organizacionDeportivaEntity;

    public CanchaEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setUbicacionPrecisaEntity(UbicacionPrecisaEntity.obtenerUbicacionPrecisaDefecto());
        setTipoCanchaEntity(TipoCanchaEntity.obtenerTipoCanchaDefecto());
        setOrganizacionDeportivaEntity(OrganizacionDeportivaEntity.obtenerOrganizacionDeportivaDefecto());
    }

    public CanchaEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setUbicacionPrecisaEntity(UbicacionPrecisaEntity.obtenerUbicacionPrecisaDefecto());
        setTipoCanchaEntity(TipoCanchaEntity.obtenerTipoCanchaDefecto());
        setOrganizacionDeportivaEntity(OrganizacionDeportivaEntity.obtenerOrganizacionDeportivaDefecto());
    }

    public CanchaEntity(final UUID id, String nombre, UbicacionPrecisaEntity ubicacionPrecisaEntity, TipoCanchaEntity tipoCanchaEntity, OrganizacionDeportivaEntity organizacionDeportivaEntity) {
        setId(id);
        setNombre(nombre);
        setUbicacionPrecisaEntity(ubicacionPrecisaEntity);
        setTipoCanchaEntity(tipoCanchaEntity);
        setOrganizacionDeportivaEntity(organizacionDeportivaEntity);
    }

    public static CanchaEntity obtenerCanchaDefecto() {
        return new CanchaEntity();
    }

    public static CanchaEntity obtenerValorDefecto(CanchaEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerCanchaDefecto());
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

    public UbicacionPrecisaEntity getUbicacionPrecisaEntity() {
        return ubicacionPrecisaEntity;
    }

    public void setUbicacionPrecisaEntity(final UbicacionPrecisaEntity ubicacionPrecisaEntity) {
        this.ubicacionPrecisaEntity = UbicacionPrecisaEntity.obtenerValorDefecto(ubicacionPrecisaEntity);
    }
    public TipoCanchaEntity getTipoCanchaEntity() {
        return tipoCanchaEntity;
    }

    public void setTipoCanchaEntity(final TipoCanchaEntity tipoCanchaEntity) {
        this.tipoCanchaEntity = TipoCanchaEntity.obtenerValorDefecto(tipoCanchaEntity);
    }
    public OrganizacionDeportivaEntity getOrganizacionDeportivaEntity() {
        return organizacionDeportivaEntity;
    }

    public void setOrganizacionDeportivaEntity(final OrganizacionDeportivaEntity organizacionDeportivaEntity) {
        this.organizacionDeportivaEntity = OrganizacionDeportivaEntity.obtenerValorDefecto(organizacionDeportivaEntity);
    }
}


