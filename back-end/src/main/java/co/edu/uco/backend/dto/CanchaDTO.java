package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class CanchaDTO {

    private UUID id;
    private String nombre;
    private UbicacionPrecisaDTO ubicacionPrecisaDTO;
    private TipoCanchaDTO tipoCanchaDTO;
    private OrganizacionDeportivaDTO organizacionDeportivaDTO;

    public CanchaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setUbicacionPrecisaDTO(UbicacionPrecisaDTO.obtenerValorDefecto());
        setTipoCanchaDTO(TipoCanchaDTO.obtenerValorDefecto());
        setOrganizacionDeportivaDTO(OrganizacionDeportivaDTO.obtenerValorDefecto());
    }

    public CanchaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setUbicacionPrecisaDTO(UbicacionPrecisaDTO.obtenerValorDefecto());
        setTipoCanchaDTO(TipoCanchaDTO.obtenerValorDefecto());
        setOrganizacionDeportivaDTO(OrganizacionDeportivaDTO.obtenerValorDefecto());
    }

    public CanchaDTO(final UUID id, final String nombre, UbicacionPrecisaDTO ubicacionPrecisaDTO, TipoCanchaDTO tipoCanchaDTO, OrganizacionDeportivaDTO organizacionDeportivaDTO) {
        setId(id);
        setNombre(nombre);
        setUbicacionPrecisaDTO(ubicacionPrecisaDTO);
        setTipoCanchaDTO(tipoCanchaDTO);
        setOrganizacionDeportivaDTO(organizacionDeportivaDTO);
    }

    public UUID getId() {
        return id;
    }

    public CanchaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public CanchaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public UbicacionPrecisaDTO getUbicacionPrecisaDTO() {
        return ubicacionPrecisaDTO;
    }

    public CanchaDTO setUbicacionPrecisaDTO(final UbicacionPrecisaDTO ubicacionPrecisaDTO) {
        this.ubicacionPrecisaDTO = UbicacionPrecisaDTO.obtenerValorDefecto(ubicacionPrecisaDTO);
        return this;
    }
    public TipoCanchaDTO getTipoCanchaDTO() {
        return tipoCanchaDTO;
    }

    public CanchaDTO setTipoCanchaDTO(final TipoCanchaDTO tipoCanchaDTO) {
        this.tipoCanchaDTO = TipoCanchaDTO.obtenerValorDefecto(tipoCanchaDTO);
        return this;
    }
    public OrganizacionDeportivaDTO getOrganizacionDeportivaDTO() {
        return organizacionDeportivaDTO;
    }

    public CanchaDTO setOrganizacionDeportivaDTO(final OrganizacionDeportivaDTO organizacionDeportivaDTO) {
        this.organizacionDeportivaDTO = OrganizacionDeportivaDTO.obtenerValorDefecto(organizacionDeportivaDTO);
        return this;
    }

    public static CanchaDTO obtenerValorDefecto() {
        return new CanchaDTO();
    }

    public static CanchaDTO obtenerValorDefecto(final CanchaDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }
}
