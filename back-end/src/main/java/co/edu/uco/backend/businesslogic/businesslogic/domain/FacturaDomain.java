package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class FacturaDomain {

    private UUID id;
    private String nombre;
    private ReservaDomain reserva;

    FacturaDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setReserva(ReservaDomain.obtenerReservaDefecto());
    }

    public FacturaDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setReserva(ReservaDomain.obtenerReservaDefecto());
    }

    public FacturaDomain(final UUID id, final String nombre, ReservaDomain reserva) {
        setId(id);
        setNombre(nombre);
        setReserva(reserva);
    }

    static FacturaDomain obtenerFacturaDefecto() {
        return new FacturaDomain();
    }

    static FacturaDomain obtenerValorDefecto(FacturaDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerFacturaDefecto());
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

    public ReservaDomain getReserva() {
        return reserva;
    }

    private void setReserva(final ReservaDomain reserva) {
        this.reserva = ReservaDomain.obtenerValorDefecto(reserva);
    }
}