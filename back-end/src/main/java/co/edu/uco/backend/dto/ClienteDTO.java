package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class ClienteDTO {

    private UUID id;
    private String nombre;


    public ClienteDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public ClienteDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public ClienteDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);

    }

    public UUID getId() {
        return id;
    }

    public ClienteDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public ClienteDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }



    public static ClienteDTO obtenerValorDefecto() {
        return new ClienteDTO();
    }

    public static ClienteDTO obtenerValorDefecto(final ClienteDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }
}
