package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class EstadoVerificacionDTO {

    private UUID id;
    private String nombre;


    public EstadoVerificacionDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public EstadoVerificacionDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public EstadoVerificacionDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);

    }

    public UUID getId() {
        return id;
    }

    public EstadoVerificacionDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoVerificacionDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }



    public static EstadoVerificacionDTO obtenerEstadoVerificacionDefecto() {
        return new EstadoVerificacionDTO();
    }

    public static EstadoVerificacionDTO obtenerEstadoVerificacionDefecto(final EstadoVerificacionDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerEstadoVerificacionDefecto());
    }
}
