package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class HorarioDisponibleDTO {

    private UUID id;
    private String nombre;
    private CanchaDTO canchaDTO;
    private DiaSemanaDTO diaSemanaDTO;

    public HorarioDisponibleDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaDTO(CanchaDTO.obtenerValorDefecto());
        setDiaSemanaDTO(DiaSemanaDTO.obtenerValorDefecto());
    }

    public HorarioDisponibleDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaDTO(CanchaDTO.obtenerValorDefecto());
        setDiaSemanaDTO(DiaSemanaDTO.obtenerValorDefecto());
    }

    public HorarioDisponibleDTO(final UUID id, final String nombre, CanchaDTO canchaDTO, DiaSemanaDTO diaSemanaDTO) {
        setId(id);
        setNombre(nombre);
        setCanchaDTO(canchaDTO);
        setDiaSemanaDTO(diaSemanaDTO);
    }

    public UUID getId() {
        return id;
    }

    public HorarioDisponibleDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public HorarioDisponibleDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public CanchaDTO getCanchaDTO() {
        return canchaDTO;
    }

    public HorarioDisponibleDTO setCanchaDTO(final CanchaDTO canchaDTO) {
        this.canchaDTO = CanchaDTO.obtenerValorDefecto(canchaDTO);
        return this;
    }
    public DiaSemanaDTO getDiaSemanaDTO() {
        return diaSemanaDTO;
    }

    public HorarioDisponibleDTO setDiaSemanaDTO(final DiaSemanaDTO diaSemanaDTO) {
        this.diaSemanaDTO = DiaSemanaDTO.obtenerValorDefecto(diaSemanaDTO);
        return this;
    }

    public static HorarioDisponibleDTO obtenerValorDefecto() {
        return new HorarioDisponibleDTO();
    }

    public static HorarioDisponibleDTO obtenerValorDefecto(final HorarioDisponibleDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }
}
