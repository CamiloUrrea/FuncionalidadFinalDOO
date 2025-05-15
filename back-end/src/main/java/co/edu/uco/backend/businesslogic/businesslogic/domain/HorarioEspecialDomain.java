package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class HorarioEspecialDomain {

    private UUID id;
    private String nombre;
    private CanchaDomain cancha;

    HorarioEspecialDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCancha(CanchaDomain.obtenerCanchaDefecto());
    }

    public HorarioEspecialDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCancha(CanchaDomain.obtenerCanchaDefecto());
    }

    public HorarioEspecialDomain(final UUID id, final String nombre, CanchaDomain cancha) {
        setId(id);
        setNombre(nombre);
        setCancha(cancha);
    }

    static HorarioEspecialDomain obtenerHorarioEspecialDefecto() {
        return new HorarioEspecialDomain();
    }

    static HorarioEspecialDomain obtenerValorDefecto(HorarioEspecialDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerHorarioEspecialDefecto());
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
}