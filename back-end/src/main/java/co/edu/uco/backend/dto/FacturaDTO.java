package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class FacturaDTO {

    private UUID id;
    private String nombre;
    private ReservaDTO reservaDTO;

    public FacturaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setReservaDTO(ReservaDTO.obtenerReservaDefecto());
    }

    public FacturaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setReservaDTO(ReservaDTO.obtenerReservaDefecto());
    }

    public FacturaDTO(final UUID id, final String nombre, ReservaDTO reservaDTO) {
        setId(id);
        setNombre(nombre);
        setReservaDTO(reservaDTO);
    }

    public UUID getId() {
        return id;
    }

    public FacturaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public FacturaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public ReservaDTO getReservaDTO() {
        return reservaDTO;
    }

    public FacturaDTO setReservaDTO(final ReservaDTO reservaDTO) {
        this.reservaDTO = ReservaDTO.obtenerValorDefecto(reservaDTO);
        return this;
    }

    public static FacturaDTO obtenerFacturaDefecto() {
        return new FacturaDTO();
    }

    public static FacturaDTO obtenerFacturaDefecto(final FacturaDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerFacturaDefecto());
    }
}
