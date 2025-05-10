package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class MunicipioDTO {

    private UUID id;
    private String nombre;
    private DepartamentoDTO departamentoDTO;

    public MunicipioDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamentoDTO(DepartamentoDTO.obtenerDepartamentoDefecto());
    }

    public MunicipioDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamentoDTO(DepartamentoDTO.obtenerDepartamentoDefecto());
    }

    public MunicipioDTO(final UUID id, final String nombre, DepartamentoDTO departamentoDTO) {
        setId(id);
        setNombre(nombre);
        setDepartamentoDTO(departamentoDTO);
    }

    public UUID getId() {
        return id;
    }

    public MunicipioDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public MunicipioDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public DepartamentoDTO getDepartamentoDTO() {
        return departamentoDTO;
    }

    public MunicipioDTO setDepartamentoDTO(final DepartamentoDTO departamentoDTO) {
        this.departamentoDTO = DepartamentoDTO.obtenerValorDefecto(departamentoDTO);
        return this;
    }

    public static MunicipioDTO obtenerMunicipioDefecto() {
        return new MunicipioDTO();
    }

    public static MunicipioDTO obtenerMunicipioDefecto(final MunicipioDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerMunicipioDefecto());
    }
}
