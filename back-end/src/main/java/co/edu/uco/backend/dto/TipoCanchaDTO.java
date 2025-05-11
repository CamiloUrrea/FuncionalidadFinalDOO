package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class TipoCanchaDTO {

    private UUID id;
    private String nombre;


    public TipoCanchaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public TipoCanchaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public TipoCanchaDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);

    }

    public UUID getId() {
        return id;
    }

    public TipoCanchaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCanchaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }



    public static TipoCanchaDTO obtenerValorDefecto() {
        return new TipoCanchaDTO();
    }

    public static TipoCanchaDTO obtenerValorDefecto(final TipoCanchaDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }
}
