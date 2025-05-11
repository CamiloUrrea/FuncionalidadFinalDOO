package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class UbicacionPrecisaDTO {

    private UUID id;
    private String nombre;
    private MunicipioDTO municipioDTO;

    public UbicacionPrecisaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMunicipioDTO(MunicipioDTO.obtenerValorDefecto());
    }

    public UbicacionPrecisaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMunicipioDTO(MunicipioDTO.obtenerValorDefecto());
    }

    public UbicacionPrecisaDTO(final UUID id, final String nombre, MunicipioDTO municipioDTO) {
        setId(id);
        setNombre(nombre);
        setMunicipioDTO(municipioDTO);
    }

    public UUID getId() {
        return id;
    }

    public UbicacionPrecisaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public UbicacionPrecisaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public MunicipioDTO getMunicipioDTO() {
        return municipioDTO;
    }

    public UbicacionPrecisaDTO setMunicipioDTO(final MunicipioDTO municipioDTO) {
        this.municipioDTO = MunicipioDTO.obtenerValorDefecto(municipioDTO);
        return this;
    }

    public static UbicacionPrecisaDTO obtenerValorDefecto() {
        return new UbicacionPrecisaDTO();
    }

    public static UbicacionPrecisaDTO obtenerValorDefecto(final UbicacionPrecisaDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }
}
