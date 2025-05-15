package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class ReservaDomain {

    private UUID id;
    private String nombre;
    private CanchaDomain cancha;
    private ClienteDomain cliente;
    private EstadoReservaDomain estadoReserva;

    ReservaDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCancha(CanchaDomain.obtenerCanchaDefecto());
        setCliente(ClienteDomain.obtenerClienteDefecto());
        setEstadoReserva(EstadoReservaDomain.obtenerEstadoReservaDefecto());
    }

    public ReservaDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCancha(CanchaDomain.obtenerCanchaDefecto());
        setCliente(ClienteDomain.obtenerClienteDefecto());
        setEstadoReserva(EstadoReservaDomain.obtenerEstadoReservaDefecto());
    }

    public ReservaDomain(final UUID id, final String nombre, CanchaDomain cancha, ClienteDomain cliente, EstadoReservaDomain estadoReserva) {
        setId(id);
        setNombre(nombre);
        setCancha(cancha);
        setCliente(cliente);
        setEstadoReserva(estadoReserva);
    }

    static ReservaDomain obtenerReservaDefecto() {
        return new ReservaDomain();
    }

    static ReservaDomain obtenerValorDefecto(ReservaDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerReservaDefecto());
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

    public ClienteDomain getCliente() {
        return cliente;
    }

    private void setCliente(final ClienteDomain cliente) {
        this.cliente = ClienteDomain.obtenerValorDefecto(cliente);
    }

    public EstadoReservaDomain getEstadoReserva() {
        return estadoReserva;
    }

    private void setEstadoReserva(final EstadoReservaDomain estadoReserva) {
        this.estadoReserva = EstadoReservaDomain.obtenerValorDefecto(estadoReserva);
    }
}