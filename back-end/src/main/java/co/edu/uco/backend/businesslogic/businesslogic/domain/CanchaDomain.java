package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class CanchaDomain {

    private UUID id;
    private String nombre;
    private UbicacionPrecisaDomain ubicacionPrecisa;
    private TipoCanchaDomain tipoCancha;
    private OrganizacionDeportivaDomain organizacionDeportiva;

    CanchaDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setUbicacionPrecisa(UbicacionPrecisaDomain.obtenerUbicacionPrecisaDefecto());
        setTipoCancha(TipoCanchaDomain.obtenerTipoCanchaDefecto());
        setOrganizacionDeportiva(OrganizacionDeportivaDomain.obtenerOrganizacionDeportivaDefecto());
    }

    public CanchaDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setUbicacionPrecisa(UbicacionPrecisaDomain.obtenerUbicacionPrecisaDefecto());
        setTipoCancha(TipoCanchaDomain.obtenerTipoCanchaDefecto());
        setOrganizacionDeportiva(OrganizacionDeportivaDomain.obtenerOrganizacionDeportivaDefecto());
    }

    public CanchaDomain(final UUID id, final String nombre, UbicacionPrecisaDomain ubicacionPrecisa, TipoCanchaDomain tipoCancha, OrganizacionDeportivaDomain organizacionDeportiva) {
        setId(id);
        setNombre(nombre);
        setUbicacionPrecisa(ubicacionPrecisa);
        setTipoCancha(tipoCancha);
        setOrganizacionDeportiva(organizacionDeportiva);
    }

    static CanchaDomain obtenerCanchaDefecto() {
        return new CanchaDomain();
    }

    static CanchaDomain obtenerValorDefecto(CanchaDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerCanchaDefecto());
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

    public UbicacionPrecisaDomain getUbicacionPrecisa() {
        return ubicacionPrecisa;
    }

    private void setUbicacionPrecisa(final UbicacionPrecisaDomain ubicacionPrecisa) {
        this.ubicacionPrecisa = UbicacionPrecisaDomain.obtenerValorDefecto(ubicacionPrecisa);
    }

    public TipoCanchaDomain getTipoCancha() {
        return tipoCancha;
    }

    private void setTipoCancha(final TipoCanchaDomain tipoCancha) {
        this.tipoCancha = TipoCanchaDomain.obtenerValorDefecto(tipoCancha);
    }

    public OrganizacionDeportivaDomain getOrganizacionDeportiva() {
        return organizacionDeportiva;
    }

    private void setOrganizacionDeportiva(final OrganizacionDeportivaDomain organizacionDeportiva) {
        this.organizacionDeportiva = OrganizacionDeportivaDomain.obtenerValorDefecto(organizacionDeportiva);
    }
}