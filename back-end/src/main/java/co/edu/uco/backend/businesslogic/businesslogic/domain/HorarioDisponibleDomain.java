package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.*;

import java.time.LocalTime;
import java.util.UUID;

public final class HorarioDisponibleDomain {

    private UUID id;
    private CanchaDomain cancha;
    private DiaSemanaDomain dia;
    private LocalTime horaApertura;
    private LocalTime horaCierre;

    HorarioDisponibleDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setCancha(CanchaDomain.obtenerCanchaDefecto());
        setDia(DiaSemanaDomain.obtenerDiaSemanaDefecto());
        setHoraApertura(LocalTime.MIDNIGHT);
        setHoraCierre(LocalTime.MIDNIGHT);
    }

    public HorarioDisponibleDomain(UUID id) {
        setId(id);
        setCancha(CanchaDomain.obtenerCanchaDefecto());
        setDia(DiaSemanaDomain.obtenerDiaSemanaDefecto());
        setHoraApertura(LocalTime.MIDNIGHT);
        setHoraCierre(LocalTime.MIDNIGHT);
    }

    public HorarioDisponibleDomain(final UUID id,final CanchaDomain cancha, final DiaSemanaDomain dia, final LocalTime horaApertura, final LocalTime horaCierre) {
        setId(id);
        setCancha(cancha);
        setDia(dia);
        setHoraApertura(horaApertura);
        setHoraCierre(horaCierre);
    }

    static HorarioDisponibleDomain obtenerHorarioDisponibleDefecto() {
        return new HorarioDisponibleDomain();
    }

    static HorarioDisponibleDomain obtenerValorDefecto(final HorarioDisponibleDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerHorarioDisponibleDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public CanchaDomain getCancha() {
        return cancha;
    }

    private void setCancha(final CanchaDomain cancha) {
        this.cancha = CanchaDomain.obtenerValorDefecto(cancha);
    }

    public DiaSemanaDomain getDia() {
        return dia;
    }

    private void setDia(final DiaSemanaDomain dia) {
        this.dia = DiaSemanaDomain.obtenerValorDefecto(dia);
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    private void setHoraApertura(final LocalTime horaApertura) {
        this.horaApertura = UtilObjeto.getInstance().obtenerValorDefecto(horaApertura, LocalTime.MIDNIGHT);
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    private void setHoraCierre(final LocalTime horaCierre) {
        this.horaCierre = UtilObjeto.getInstance().obtenerValorDefecto(horaCierre, LocalTime.MIDNIGHT);
    }
}
