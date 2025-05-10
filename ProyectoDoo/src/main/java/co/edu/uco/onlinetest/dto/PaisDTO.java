package co.edu.uco.onlinetest.dto;

import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class PaisDTO {

    private UUID id;
    private String nombre;

    public PaisDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private PaisDTO(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        builder.crear();
    }

    public PaisDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public PaisDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static PaisDTO obtenerPaisDefecto() {

        return new PaisDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
    }

    public static PaisDTO obtenerPaisDefecto(final PaisDTO pais) {
        return UtilObjeto.getInstance().obtenerValorDefecto(pais, PaisDTO.obtenerPaisDefecto());
    }

    public static class Builder {
        private UUID id;
        private String nombre;

        public Builder id(final UUID id) {
            this.id = id;
            return this;
        }

        public Builder nombre(final String nombre) {
            this.nombre = nombre;
            return this;
        }

        public PaisDTO crear() {
            return new PaisDTO(this);
        }
    }

}
