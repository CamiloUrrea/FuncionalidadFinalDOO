package co.edu.uco.backend.businesslogic.businesslogic.domain;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class ClienteDomain {

    private UUID id;
    private String nombre;

    ClienteDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public ClienteDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public ClienteDomain(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    static ClienteDomain obtenerClienteDefecto() {
        return new ClienteDomain();
    }

    static ClienteDomain obtenerValorDefecto(ClienteDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerClienteDefecto());
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
}