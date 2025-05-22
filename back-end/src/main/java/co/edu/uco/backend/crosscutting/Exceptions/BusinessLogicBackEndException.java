package co.edu.uco.backend.crosscutting.Exceptions;

public class BusinessLogicBackEndException extends BackEndException {

    private static final long serialVersionUID = 6950855047355313810L;
    private BusinessLogicBackEndException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.BUSINESS_LOGIC);
    }
    public static BackEndException reportar(String mensajeUsuario) {
        return new BusinessLogicBackEndException(mensajeUsuario, mensajeUsuario,new Exception());
    }

    public static BackEndException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new BusinessLogicBackEndException(mensajeUsuario, mensajeTecnico,new Exception());
    }

    public static BackEndException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new BusinessLogicBackEndException(mensajeUsuario, mensajeTecnico,new excepcionRaiz());
    }




}
