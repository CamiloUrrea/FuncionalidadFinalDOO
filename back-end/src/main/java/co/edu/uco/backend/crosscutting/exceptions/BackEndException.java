package co.edu.uco.backend.crosscutting.exceptions;

import co.edu.uco.backend.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;

import java.io.Serial;
import java.sql.SQLException;

public class BackEndException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;
    private String mensajeUsuario;
    private LayerException capa;

    // Constructor principal: recibe mensajeUsuario, mensajeTecnico, excepción raíz y capa
    public BackEndException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz, LayerException capa) {
        super(mensajeTecnico, excepcionRaiz);
        setMensajeUsuario(mensajeUsuario);
        setCapa(capa);
    }

    // Si quieres lanzar con mensajeUsuario + SQLException:
    public BackEndException(String mensajeUsuario, SQLException exception) {
        super(UtilTexto.getInstance().obtenerValorDefecto(exception == null ? null : exception.getMessage()), exception);
        setMensajeUsuario(mensajeUsuario);
        setCapa(LayerException.GENERAL);
    }

    // Si solo necesitas mensajeUsuario y mensajeTécnico (sin exception raiz ni capa):
    public BackEndException(String mensajeUsuario, String mensajeTecnico) {
        super(mensajeTecnico);
        setMensajeUsuario(mensajeUsuario);
        setCapa(LayerException.GENERAL);
    }

    @Override
    public String getMessage() {
        // Esto hace que ex.getMessage() sea siempre el texto de usuario
        return mensajeUsuario;
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    private void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = UtilTexto.getInstance()
                .quitarEspaciosEnBlancoInicioFin(UtilTexto.getInstance().obtenerValorDefecto(mensajeUsuario));
    }

    public String getMensajeTecnico() {
        // Devuelve el mensaje técnico (el que se pasó a super(...))
        return UtilTexto.getInstance().obtenerValorDefecto(super.getMessage());
    }

    public Throwable getExcepcionRaiz() {
        return UtilObjeto.getInstance()
                .obtenerValorDefecto(getCause(), new Exception(getMensajeUsuario()));
    }

    public LayerException getCapa() {
        return capa;
    }

    private void setCapa(LayerException capa) {
        this.capa = UtilObjeto.getInstance().obtenerValorDefecto(capa, LayerException.GENERAL);
    }
}

