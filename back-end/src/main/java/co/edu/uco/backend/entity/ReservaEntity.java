package co.edu.uco.backend.entity;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class ReservaEntity {

    private UUID id;
    private String nombre;
    private CanchaEntity canchaEntity;
    private ClienteEntity clienteEntity;
    private EstadoReservaEntity estadoReservaEntity;

    public ReservaEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaEntity(CanchaEntity.obtenerCanchaDefecto());
        setClienteEntity(ClienteEntity.obtenerClienteDefecto());
        setEstadoReservaEntity(EstadoReservaEntity.obtenerEstadoReservaDefecto());
    }

    public ReservaEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaEntity(CanchaEntity.obtenerCanchaDefecto());
        setClienteEntity(ClienteEntity.obtenerClienteDefecto());
        setEstadoReservaEntity(EstadoReservaEntity.obtenerEstadoReservaDefecto());
    }

    public ReservaEntity(final UUID id, String nombre, CanchaEntity canchaEntity, ClienteEntity clienteEntity, EstadoReservaEntity estadoReservaEntity) {
        setId(id);
        setNombre(nombre);
        setCanchaEntity(canchaEntity);
        setClienteEntity(clienteEntity);
        setEstadoReservaEntity(estadoReservaEntity);
    }

    public static ReservaEntity obtenerReservaDefecto() {
        return new ReservaEntity();
    }

    public static ReservaEntity obtenerValorDefecto(ReservaEntity entidadOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entidadOriginal, obtenerReservaDefecto());
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
    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(final ClienteEntity clienteEntity) {
        this.clienteEntity = ClienteEntity.obtenerValorDefecto(clienteEntity);
    }
    public EstadoReservaEntity getEstadoReservaEntity() {
        return estadoReservaEntity;
    }

    public void setEstadoReservaEntity(final EstadoReservaEntity estadoReservaEntity) {
        this.estadoReservaEntity = EstadoReservaEntity.obtenerValorDefecto(estadoReservaEntity);
    }
}
