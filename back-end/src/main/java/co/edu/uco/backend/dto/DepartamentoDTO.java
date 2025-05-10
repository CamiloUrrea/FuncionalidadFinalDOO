package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class DepartamentoDTO {

    private UUID id;
    private String nombre;


    public DepartamentoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public DepartamentoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public DepartamentoDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);

    }

    public UUID getId() {
        return id;
    }

    public DepartamentoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public DepartamentoDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }



    public static DepartamentoDTO obtenerDepartamentoDefecto() {
        return new DepartamentoDTO();
    }

    public static DepartamentoDTO obtenerDepartamentoDefecto(final DepartamentoDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerDepartamentoDefecto());
    }
}
