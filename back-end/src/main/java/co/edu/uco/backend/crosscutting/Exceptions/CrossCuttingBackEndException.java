package co.edu.uco.backend.crosscutting.Exceptions;

public class CrossCuttingBackEndException extends BackEndException {

    private static final long serialVersionUID = 6950855047355313810L;
    private CrossCuttingBackEndException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.CROSSCUTTING);
    }
    public static BackEndException reportar(String mensajeUsuario) {
        return new CrossCuttingBackEndException(mensajeUsuario, mensajeUsuario,new Exception());
    }

    public static BackEndException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new CrossCuttingBackEndException(mensajeUsuario, mensajeTecnico,new Exception());
    }

    public static BackEndException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new CrossCuttingBackEndException(mensajeUsuario, mensajeTecnico,new excepcionRaiz());
    }




}
