package co.edu.uco.onlinetest.dto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.onlinetest.dto.PaisDTO;

import java.util.UUID;

public final class DepartamentoDTO {
    private UUID id;
    private String nombre;
    private PaisDTO pais;

    public DepartamentoDTO(final Builder builder){
        setId(builder.id);
        setNombre(builder.nombre);
        setPaisDTO(builder.pais);
        builder.crear();
    }

    private void setPaisDTO(PaisDTO pais) {
        this.pais = PaisDTO.obtenerPaisDefecto(pais);
    }

    public DepartamentoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPais(PaisDTO.obtenerPaisDefecto());
    }

    public DepartamentoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPais(PaisDTO.obtenerPaisDefecto());
    }

    public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }


    public static DepartamentoDTO obtenerDepartamentoDefecto() {
        return new DepartamentoDTO();
    }

    public static DepartamentoDTO obtenerValorDefecto(DepartamentoDTO departamentoDTO) {
        return UtilObjeto.getInstance().obtenerValorDefecto(departamentoDTO, obtenerDepartamentoDefecto());
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

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().obtenerValorDefecto(nombre);
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(final PaisDTO pais) {
        this.pais = PaisDTO.obtenerPaisDefecto(pais);
    }

    public static class Builder {
        public PaisDTO pais;
        private UUID id;
        private String nombre;

        public DepartamentoDTO.Builder id(final UUID id) {
            this.id = id;
            return this;
        }

        public DepartamentoDTO.Builder nombre(final String nombre) {
            this.nombre = nombre;
            return this;
        }
        public DepartamentoDTO.Builder pais(final PaisDTO pais) {
            this.pais = pais;
            return this;
        }

        public DepartamentoDTO crear() {
            return new DepartamentoDTO(this);
        }
    }
}
