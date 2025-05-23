package co.edu.uco.backend.crosscutting.Exceptions;

public class DataBackEndException extends BackEndException {

    private static final long serialVersionUID = 1L;


    private DataBackEndException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.DATA);
    }



    public static BackEndException reportar(String mensajeUsuario) {
        return new DataBackEndException(mensajeUsuario, mensajeUsuario,new Exception());
    }

    public static BackEndException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new DataBackEndException(mensajeUsuario, mensajeTecnico,new Exception());
    }

    public static BackEndException reportar(String mensajeUsuario, String mensajeTecnico, Exception ExcepcionRaiz) {
        return new DataBackEndException(mensajeUsuario, mensajeTecnico, ExcepcionRaiz);
    }




}
