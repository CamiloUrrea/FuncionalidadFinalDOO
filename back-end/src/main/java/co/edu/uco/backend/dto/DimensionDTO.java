package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;

import java.util.UUID;

public final class DimensionDTO {

    private UUID id;
    private String nombre;

    public DimensionDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public DimensionDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public DimensionDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public UUID getId() {
        return id;
    }

    public DimensionDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public DimensionDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public static DimensionDTO obtenerValorDefecto() {
        return new DimensionDTO();
    }

    public static DimensionDTO obtenerValorDefecto(final DimensionDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }
}
