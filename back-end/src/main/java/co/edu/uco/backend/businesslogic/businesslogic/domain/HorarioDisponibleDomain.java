package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class HorarioDisponibleDomain {

    private UUID id;
    private String nombre;
    private CanchaDomain cancha;
    private DiaSemanaDomain diaSemana;

    HorarioDisponibleDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCancha(CanchaDomain.obtenerCanchaDefecto());
        setDiaSemana(DiaSemanaDomain.obtenerDiaSemanaDefecto());
    }

    public HorarioDisponibleDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCancha(CanchaDomain.obtenerCanchaDefecto());
        setDiaSemana(DiaSemanaDomain.obtenerDiaSemanaDefecto());
    }

    public HorarioDisponibleDomain(final UUID id, final String nombre, CanchaDomain cancha, DiaSemanaDomain diaSemana) {
        setId(id);
        setNombre(nombre);
        setCancha(cancha);
        setDiaSemana(diaSemana);
    }

    static HorarioDisponibleDomain obtenerHorarioDisponibleDefecto() {
        return new HorarioDisponibleDomain();
    }

    static HorarioDisponibleDomain obtenerValorDefecto(HorarioDisponibleDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerHorarioDisponibleDefecto());
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

    public CanchaDomain getCancha() {
        return cancha;
    }

    private void setCancha(final CanchaDomain cancha) {
        this.cancha = CanchaDomain.obtenerValorDefecto(cancha);
    }

    public DiaSemanaDomain getDiaSemana() {
        return diaSemana;
    }

    private void setDiaSemana(final DiaSemanaDomain diaSemana) {
        this.diaSemana = DiaSemanaDomain.obtenerValorDefecto(diaSemana);
    }
}