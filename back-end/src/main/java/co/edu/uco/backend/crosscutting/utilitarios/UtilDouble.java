package co.edu.uco.backend.crosscutting.utilitarios;

public final class UtilDouble {

    private static final double VALOR_DEFECTO = 0.0;

    private UtilDouble() {
        super();
    }

    public static double obtenerValorDefecto(final Double valor) {
        return UtilObjeto.getInstance().obtenerValorDefecto(valor, VALOR_DEFECTO);
    }

    public static boolean esPositivo(final Double valor) {
        return obtenerValorDefecto(valor) > 0.0;
    }

    public static boolean esNegativo(final Double valor) {
        return obtenerValorDefecto(valor) < 0.0;
    }

    public static boolean esCero(final Double valor) {
        return obtenerValorDefecto(valor) == 0.0;
    }
}
