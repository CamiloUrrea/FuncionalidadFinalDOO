package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class HorarioEspecialDTO {

    private UUID id;
    private String nombre;
    private CanchaDTO canchaDTO;

    public HorarioEspecialDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaDTO(CanchaDTO.obtenerCanchaDefecto());
    }

    public HorarioEspecialDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaDTO(CanchaDTO.obtenerCanchaDefecto());
    }

    public HorarioEspecialDTO(final UUID id, final String nombre, CanchaDTO canchaDTO) {
        setId(id);
        setNombre(nombre);
        setCanchaDTO(canchaDTO);
    }

    public UUID getId() {
        return id;
    }

    public HorarioEspecialDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public HorarioEspecialDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public CanchaDTO getCanchaDTO() {
        return canchaDTO;
    }

    public HorarioEspecialDTO setCanchaDTO(final CanchaDTO canchaDTO) {
        this.canchaDTO = CanchaDTO.obtenerValorDefecto(canchaDTO);
        return this;
    }

    public static HorarioEspecialDTO obtenerHorarioEspecialDefecto() {
        return new HorarioEspecialDTO();
    }

    public static HorarioEspecialDTO obtenerHorarioEspecialDefecto(final HorarioEspecialDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerHorarioEspecialDefecto());
    }
}
