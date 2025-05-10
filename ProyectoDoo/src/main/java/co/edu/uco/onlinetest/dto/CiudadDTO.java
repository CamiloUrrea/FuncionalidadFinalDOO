package co.edu.uco.onlinetest.dto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.onlinetest.dto.DepartamentoDTO;

import java.util.UUID;

public final class CiudadDTO {
    private UUID id;
    private String nombre;
    private DepartamentoDTO departamentoDTO;

    public CiudadDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamento(DepartamentoDTO.obtenerDepartamentoDefecto());
    }

    public CiudadDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamento(DepartamentoDTO.obtenerDepartamentoDefecto());
    }

    public CiudadDTO(final UUID id, String nombre, DepartamentoDTO departamentoEntity) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamentoEntity);
    }

    public CiudadDTO(Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setDepartamento(builder.departamentoDTO);
        builder.crear();
    }

    public static CiudadDTO obtenerCiudadDefecto() {
        return new CiudadDTO();
    }
    public static CiudadDTO obtenerValorDefecto(CiudadDTO ciudadDTO) {
        return UtilObjeto.getInstance().obtenerValorDefecto(ciudadDTO, obtenerCiudadDefecto());
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
        this.nombre =   UtilTexto.getInstance().obtenerValorDefecto(nombre);
    }

    public DepartamentoDTO getDepartamento() {
        return departamentoDTO;
    }

    public void setDepartamento(final DepartamentoDTO departamentoEntity) {
        this.departamentoDTO = DepartamentoDTO.obtenerValorDefecto(departamentoEntity);
    }

    public static class Builder {
        private UUID id;
        private String nombre;
        private DepartamentoDTO departamentoDTO;

        public CiudadDTO.Builder id(final UUID id) {
            this.id = id;
            return this;
        }

        public CiudadDTO.Builder nombre(final String nombre) {
            this.nombre = nombre;
            return this;
        }
        public CiudadDTO.Builder departamento(final DepartamentoDTO departamento) {
            this.departamentoDTO = departamento;
            return this;
        }

        public CiudadDTO crear() {
            return new CiudadDTO(this);
        }
    }
}
