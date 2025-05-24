package co.edu.uco.backend.crosscutting.Exceptions;

import java.io.Serial;

public class BusinessLogicBackEndException extends BackEndException {

    @Serial
    private static final long serialVersionUID = 1L;

    private BusinessLogicBackEndException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.BUSINESS_LOGIC);
    }
    public static BackEndException reportar(String mensajeUsuario) {
        return new BusinessLogicBackEndException(mensajeUsuario, mensajeUsuario,new Exception());
    }

    public static BackEndException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new BusinessLogicBackEndException(mensajeUsuario, mensajeTecnico,new Exception());
    }

    public static BackEndException reportar(String mensajeUsuario, String mensajeTecnico, Exception ExcepcionRaiz) {
        return new BusinessLogicBackEndException(mensajeUsuario, mensajeTecnico, ExcepcionRaiz);
    }




}
