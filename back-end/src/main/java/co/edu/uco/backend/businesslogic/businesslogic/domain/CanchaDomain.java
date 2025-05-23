package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.*;

import java.util.List;
import java.util.UUID;

public final class CanchaDomain {

    private UUID id;
    private String nombreCancha;
    private TipoCanchaDomain tipo;
    private DimensionDomain dimensiones;
    private SuperficieDomain superficie;
    private double costoHora;
    private UbicacionPrecisaDomain ubicacion;
    private OrganizacionDeportivaDomain organizacion;
    private boolean iluminacion;
    private boolean cubierta;
    private List<HorarioDisponibleDomain> horariosDisponibles;
    private List<HorarioEspecialDomain> horariosEspeciales;

    CanchaDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombreCancha(UtilTexto.getInstance().obtenerValorDefecto());
        setTipo(TipoCanchaDomain.obtenerTipoCanchaDefecto());
        setDimensiones(DimensionDomain.obtenerDimensionDefecto());
        setSuperficie(SuperficieDomain.obtenerSuperficieDefecto());
        setCostoHora(UtilDouble.obtenerValorDefecto(0.0));
        setUbicacion(UbicacionPrecisaDomain.obtenerUbicacionPrecisaDefecto());
        setOrganizacion(OrganizacionDeportivaDomain.obtenerOrganizacionDeportivaDefecto());
        setIluminacion(UtilBooleano.obtenerValorDefecto(false));
        setCubierta(UtilBooleano.obtenerValorDefecto(false));
        setHorariosDisponibles(List.of());
        setHorariosEspeciales(List.of());
    }

    public CanchaDomain(UUID id) {
        setId(id);
        setNombreCancha(UtilTexto.getInstance().obtenerValorDefecto());
        setTipo(TipoCanchaDomain.obtenerTipoCanchaDefecto());
        setDimensiones(DimensionDomain.obtenerDimensionDefecto());
        setSuperficie(SuperficieDomain.obtenerSuperficieDefecto());
        setCostoHora(UtilDouble.obtenerValorDefecto(0.0));
        setUbicacion(UbicacionPrecisaDomain.obtenerUbicacionPrecisaDefecto());
        setOrganizacion(OrganizacionDeportivaDomain.obtenerOrganizacionDeportivaDefecto());
        setIluminacion(UtilBooleano.obtenerValorDefecto(false));
        setCubierta(UtilBooleano.obtenerValorDefecto(false));
        setHorariosDisponibles(List.of());
        setHorariosEspeciales(List.of());
    }

    public CanchaDomain(UUID id, String nombreCancha, TipoCanchaDomain tipo, DimensionDomain dimensiones,
                        SuperficieDomain superficie, double costoHora, UbicacionPrecisaDomain ubicacion,
                        OrganizacionDeportivaDomain organizacion, boolean iluminacion, boolean cubierta,
                        List<HorarioDisponibleDomain> horariosDisponibles,
                        List<HorarioEspecialDomain> horariosEspeciales) {
        setId(id);
        setNombreCancha(nombreCancha);
        setTipo(tipo);
        setDimensiones(dimensiones);
        setSuperficie(superficie);
        setCostoHora(costoHora);
        setUbicacion(ubicacion);
        setOrganizacion(organizacion);
        setIluminacion(iluminacion);
        setCubierta(cubierta);
        setHorariosDisponibles(horariosDisponibles);
        setHorariosEspeciales(horariosEspeciales);
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

    private void setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombreCancha() {
        return nombreCancha;
    }

    private void setNombreCancha(String nombreCancha) {
        this.nombreCancha = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombreCancha);
    }

    public TipoCanchaDomain getTipo() {
        return tipo;
    }

    private void setTipo(TipoCanchaDomain tipo) {
        this.tipo = TipoCanchaDomain.obtenerValorDefecto(tipo);
    }

    public DimensionDomain getDimensiones() {
        return dimensiones;
    }

    private void setDimensiones(DimensionDomain dimensiones) {
        this.dimensiones = DimensionDomain.obtenerValorDefecto(dimensiones);
    }

    public SuperficieDomain getSuperficie() {
        return superficie;
    }

    private void setSuperficie(SuperficieDomain superficie) {
        this.superficie = SuperficieDomain.obtenerValorDefecto(superficie);
    }

    public double getCostoHora() {
        return costoHora;
    }

    private void setCostoHora(double costoHora) {
        this.costoHora = UtilDouble.obtenerValorDefecto(costoHora);
    }

    public UbicacionPrecisaDomain getUbicacion() {
        return ubicacion;
    }

    private void setUbicacion(UbicacionPrecisaDomain ubicacion) {
        this.ubicacion = UbicacionPrecisaDomain.obtenerValorDefecto(ubicacion);
    }

    public OrganizacionDeportivaDomain getOrganizacion() {
        return organizacion;
    }

    private void setOrganizacion(OrganizacionDeportivaDomain organizacion) {
        this.organizacion = OrganizacionDeportivaDomain.obtenerValorDefecto(organizacion);
    }

    public boolean isIluminacion() {
        return iluminacion;
    }

    private void setIluminacion(boolean iluminacion) {
        this.iluminacion = UtilBooleano.obtenerValorDefecto(iluminacion);
    }

    public boolean isCubierta() {
        return cubierta;
    }

    private void setCubierta(boolean cubierta) {
        this.cubierta = UtilBooleano.obtenerValorDefecto(cubierta);
    }

    public List<HorarioDisponibleDomain> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    private void setHorariosDisponibles(List<HorarioDisponibleDomain> horarios) {
        this.horariosDisponibles = UtilObjeto.getInstance().obtenerValorDefecto(horarios, List.of());
    }

    public List<HorarioEspecialDomain> getHorariosEspeciales() {
        return horariosEspeciales;
    }

    private void setHorariosEspeciales(List<HorarioEspecialDomain> horarios) {
        this.horariosEspeciales = UtilObjeto.getInstance().obtenerValorDefecto(horarios, List.of());
    }
}
