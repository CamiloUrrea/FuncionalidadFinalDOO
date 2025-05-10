package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class OrganizacionDeportivaDTO {

    private UUID id;
    private String nombre;
    private EstadoVerificacionDTO estadoVerificacionDTO;

    public OrganizacionDeportivaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setEstadoVerificacionDTO(EstadoVerificacionDTO.obtenerEstadoVerificacionDefecto());
    }

    public OrganizacionDeportivaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setEstadoVerificacionDTO(EstadoVerificacionDTO.obtenerEstadoVerificacionDefecto());
    }

    public OrganizacionDeportivaDTO(final UUID id, final String nombre, EstadoVerificacionDTO estadoVerificacionDTO) {
        setId(id);
        setNombre(nombre);
        setEstadoVerificacionDTO(estadoVerificacionDTO);
    }

    public UUID getId() {
        return id;
    }

    public OrganizacionDeportivaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public OrganizacionDeportivaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public EstadoVerificacionDTO getEstadoVerificacionDTO() {
        return estadoVerificacionDTO;
    }

    public OrganizacionDeportivaDTO setEstadoVerificacionDTO(final EstadoVerificacionDTO estadoVerificacionDTO) {
        this.estadoVerificacionDTO = EstadoVerificacionDTO.obtenerValorDefecto(estadoVerificacionDTO);
        return this;
    }

    public static OrganizacionDeportivaDTO obtenerOrganizacionDeportivaDefecto() {
        return new OrganizacionDeportivaDTO();
    }

    public static OrganizacionDeportivaDTO obtenerOrganizacionDeportivaDefecto(final OrganizacionDeportivaDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerOrganizacionDeportivaDefecto());
    }
}
