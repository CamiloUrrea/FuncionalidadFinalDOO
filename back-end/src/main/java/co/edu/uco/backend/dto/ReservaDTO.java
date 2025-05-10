package co.edu.uco.backend.dto;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class ReservaDTO {

    private UUID id;
    private String nombre;
    private CanchaDTO canchaDTO;
    private ClienteDTO clienteDTO;
    private EstadoReservaDTO estadoReservaDTO;

    public ReservaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaDTO(CanchaDTO.obtenerCanchaDefecto());
        setClienteDTO(ClienteDTO.obtenerClienteDefecto());
        setEstadoReservaDTO(EstadoReservaDTO.obtenerEstadoReservaDefecto());
    }

    public ReservaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setCanchaDTO(CanchaDTO.obtenerCanchaDefecto());
        setClienteDTO(ClienteDTO.obtenerClienteDefecto());
        setEstadoReservaDTO(EstadoReservaDTO.obtenerEstadoReservaDefecto());
    }

    public ReservaDTO(final UUID id, final String nombre, CanchaDTO canchaDTO, ClienteDTO clienteDTO, EstadoReservaDTO estadoReservaDTO) {
        setId(id);
        setNombre(nombre);
        setCanchaDTO(canchaDTO);
        setClienteDTO(clienteDTO);
        setEstadoReservaDTO(estadoReservaDTO);
    }

    public UUID getId() {
        return id;
    }

    public ReservaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public ReservaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        return this;
    }

    public CanchaDTO getCanchaDTO() {
        return canchaDTO;
    }

    public ReservaDTO setCanchaDTO(final CanchaDTO canchaDTO) {
        this.canchaDTO = CanchaDTO.obtenerValorDefecto(canchaDTO);
        return this;
    }
    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public ReservaDTO setClienteDTO(final ClienteDTO clienteDTO) {
        this.clienteDTO = ClienteDTO.obtenerValorDefecto(clienteDTO);
        return this;
    }
    public EstadoReservaDTO getEstadoReservaDTO() {
        return estadoReservaDTO;
    }

    public ReservaDTO setEstadoReservaDTO(final EstadoReservaDTO estadoReservaDTO) {
        this.estadoReservaDTO = EstadoReservaDTO.obtenerValorDefecto(estadoReservaDTO);
        return this;
    }

    public static ReservaDTO obtenerReservaDefecto() {
        return new ReservaDTO();
    }

    public static ReservaDTO obtenerReservaDefecto(final ReservaDTO dto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(dto, obtenerReservaDefecto());
    }
}
