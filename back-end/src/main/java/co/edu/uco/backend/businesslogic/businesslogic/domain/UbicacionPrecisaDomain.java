package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class UbicacionPrecisaDomain {

    private UUID id;
    private String nombre;
    private MunicipioDomain municipio;

    UbicacionPrecisaDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMunicipio(MunicipioDomain.obtenerMunicipioDefecto());
    }

    public UbicacionPrecisaDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMunicipio(MunicipioDomain.obtenerMunicipioDefecto());
    }

    public UbicacionPrecisaDomain(final UUID id, final String nombre, MunicipioDomain municipio) {
        setId(id);
        setNombre(nombre);
        setMunicipio(municipio);
    }

    static UbicacionPrecisaDomain obtenerUbicacionPrecisaDefecto() {
        return new UbicacionPrecisaDomain();
    }

    static UbicacionPrecisaDomain obtenerValorDefecto(UbicacionPrecisaDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerUbicacionPrecisaDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
    }

    public MunicipioDomain getMunicipio() {
        return municipio;
    }

    private void setMunicipio(final MunicipioDomain municipio) {
        this.municipio = MunicipioDomain.obtenerValorDefecto(municipio);
    }
}