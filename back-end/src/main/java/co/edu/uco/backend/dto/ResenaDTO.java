package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class ResenaDTO {

    private UUID id;
    private String nombre;
    private ReservaDTO reservaDTO;

    public ResenaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setReservaDTO(ReservaDTO.obtenerValorDefecto());
    }

    public ResenaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setReservaDTO(ReservaDTO.obtenerValorDefecto());
    }

    public ResenaDTO(final UUID id, final String nombre, ReservaDTO reservaDTO) {
        setId(id);
        setNombre(nombre);
        setReservaDTO(reservaDTO);
    }

    public UUID getId() {
        return id;
    }

    public ResenaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public ResenaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public ReservaDTO getReservaDTO() {
        return reservaDTO;
    }

    public ResenaDTO setReservaDTO(final ReservaDTO reservaDTO) {
        this.reservaDTO = ReservaDTO.obtenerValorDefecto(reservaDTO);
        return this;
    }

    public static ResenaDTO obtenerValorDefecto() {
        return new ResenaDTO();
    }

    public static ResenaDTO obtenerValorDefecto(final ResenaDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }
}
