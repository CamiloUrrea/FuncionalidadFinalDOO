package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class DiaSemanaDTO {

    private UUID id;
    private String nombre;


    public DiaSemanaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public DiaSemanaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public DiaSemanaDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);

    }

    public UUID getId() {
        return id;
    }

    public DiaSemanaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public DiaSemanaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }



    public static DiaSemanaDTO obtenerDiaSemanaDefecto() {
        return new DiaSemanaDTO();
    }

    public static DiaSemanaDTO obtenerDiaSemanaDefecto(final DiaSemanaDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerDiaSemanaDefecto());
    }
}
