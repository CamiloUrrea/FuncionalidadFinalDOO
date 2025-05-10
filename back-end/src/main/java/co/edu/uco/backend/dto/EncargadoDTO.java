package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class EncargadoDTO {

    private UUID id;
    private String nombre;
    private OrganizacionDeportivaDTO organizacionDeportivaDTO;

    public EncargadoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setOrganizacionDeportivaDTO(OrganizacionDeportivaDTO.obtenerOrganizacionDeportivaDefecto());
    }

    public EncargadoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setOrganizacionDeportivaDTO(OrganizacionDeportivaDTO.obtenerOrganizacionDeportivaDefecto());
    }

    public EncargadoDTO(final UUID id, final String nombre, OrganizacionDeportivaDTO organizacionDeportivaDTO) {
        setId(id);
        setNombre(nombre);
        setOrganizacionDeportivaDTO(organizacionDeportivaDTO);
    }

    public UUID getId() {
        return id;
    }

    public EncargadoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public EncargadoDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public OrganizacionDeportivaDTO getOrganizacionDeportivaDTO() {
        return organizacionDeportivaDTO;
    }

    public EncargadoDTO setOrganizacionDeportivaDTO(final OrganizacionDeportivaDTO organizacionDeportivaDTO) {
        this.organizacionDeportivaDTO = OrganizacionDeportivaDTO.obtenerValorDefecto(organizacionDeportivaDTO);
        return this;
    }

    public static EncargadoDTO obtenerEncargadoDefecto() {
        return new EncargadoDTO();
    }

    public static EncargadoDTO obtenerEncargadoDefecto(final EncargadoDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerEncargadoDefecto());
    }
}
