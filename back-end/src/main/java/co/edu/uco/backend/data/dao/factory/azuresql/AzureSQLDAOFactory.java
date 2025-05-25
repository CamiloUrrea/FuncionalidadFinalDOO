package co.edu.uco.backend.data.dao.factory.azuresql;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.DataBackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.backend.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.backend.data.dao.entity.departamento.impl.azuresql.DepartamentoAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.municipio.MunicipioDAO;
import co.edu.uco.backend.data.dao.entity.municipio.impl.azuresql.MunicipioAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.UbicacionPrecisaDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.impl.azuresql.UbicacionPrecisaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.TipoCanchaDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.impl.azuresql.TipoCanchaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.horariodisponible.HorarioDisponibleDAO;
import co.edu.uco.backend.data.dao.entity.horariodisponible.impl.azuresql.HorarioDisponibleAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.horarioespecial.HorarioEspecialDAO;
import co.edu.uco.backend.data.dao.entity.horarioespecial.impl.azuresql.HorarioEspecialAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.estadoverificacion.EstadoVerificacionDAO;
import co.edu.uco.backend.data.dao.entity.estadoverificacion.impl.azuresql.EstadoVerificacionAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.OrganizacionDeportivaDAO;
import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.impl.azuresql.OrganizacionDeportivaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.encargado.EncargadoDAO;
import co.edu.uco.backend.data.dao.entity.encargado.impl.azuresql.EncargadoAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.cancha.CanchaDAO;
import co.edu.uco.backend.data.dao.entity.cancha.impl.azuresql.CanchaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.estadoreserva.EstadoReservaDAO;
import co.edu.uco.backend.data.dao.entity.estadoreserva.impl.azuresql.EstadoReservaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.cliente.ClienteDAO;
import co.edu.uco.backend.data.dao.entity.cliente.impl.azuresql.ClienteAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.reserva.ReservaDAO;
import co.edu.uco.backend.data.dao.entity.reserva.impl.azuresql.ReservaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.resena.ResenaDAO;
import co.edu.uco.backend.data.dao.entity.resena.impl.azuresql.ResenaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.factura.FacturaDAO;
import co.edu.uco.backend.data.dao.entity.factura.impl.azuresql.FacturaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.superficie.SuperficieDAO;
import co.edu.uco.backend.data.dao.entity.superficie.impl.azuresql.SuperficieAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.dimension.DimensionDAO;
import co.edu.uco.backend.data.dao.entity.dimension.impl.azuresql.DimensionAzureSQLDAO;



public abstract class AzureSQLDAOFactory extends DAOFactory {

    private final Connection conexion;
    private boolean transaccionEstaInciada;
    private boolean conexionEstaAbierta;


    /*
    protected AzureSQLDAOFactory() throws BackEndException {

        this.conexion = conexion;
        abrirConexion();
        transaccionEstaInciada = false;
        conexionEstaAbierta = true;
    }*/

    protected AzureSQLDAOFactory() throws BackEndException {
        try {
            this.conexion = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=DOODB;user=postgres;password=321325;");
            abrirConexion();
            transaccionEstaInciada = false;
            conexionEstaAbierta = true;
        } catch (SQLException excepcion) {
            throw DataBackEndException.reportar(
                    "Ocurrió un problema tratando de abrir la conexión con la base de datos.",
                    "Error al obtener conexión con Azure SQL en AzureSQLDAOFactory.",
                    excepcion
            );
        }
    }


    protected void abrirConexion() throws BackEndException {
        var baseDatos = "";
        var servidor = "";
        try {
            DriverManager.getConnection("");
            conexionEstaAbierta = true;
        }catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de obtener la conexion con la fuente de datos para llevar a cabo la operacion deseada";
            var mensajeTecnico = "Se presento una excepción de tipo SQLException tratando de obtener la conexión con la base de datos "+ baseDatos+" en el servidor "+ servidor +" para tener mas detalles, revise el log de errores";

            throw  DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de obtener la conexion con la fuente de datos para llevar a cabo la operacion deseada";
            var mensajeTecnico = "Se presento una excepción NO CONTROLADA de tipo SQLException tratando de obtener la conexión con la base de datos "+ baseDatos+" en el servidor "+ servidor +" para tener mas detalles, revise el log de errores";

           throw  DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }



    }


    @Override
    public void iniciarTransaccion() throws BackEndException{
        try {
            asegurarConexionAbierta();
            conexion.setAutoCommit(false);
            transaccionEstaInciada = true;

        }catch (BackEndException exception){
            throw exception;
        }catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de iniciar la transaccion con la fuente de datos para llevar a cabo la operacion deseada";
            var mensajeTecnico = "Se presento una excepción de tipo SQLException tratando de iniciar la conexion con la base de datos. para tener mas detalles, revise el log de errores";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de iniciar la transaccion con la fuente de datos para llevar a cabo la operacion deseada";
            var mensajeTecnico = "Se presento una excepción NO CONTROLADA de tipo SQLException tratando de iniciar la conexion con la base de datos. para tener mas detalles, revise el log de errores";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void confirmarTransaccion() throws BackEndException{
        try {
            asegurarConexionAbierta();
            conexion.commit();
            asegurarTransaccionIniciada();

        }catch (BackEndException exception){
            throw exception;

        }catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de iniciar la transaccion con la fuente de datos para llevar a cabo la operacion deseada";
            var mensajeTecnico = "Se presento una excepción de tipo SQLException tratando de iniciar la conexion con la base de datos. para tener mas detalles, revise el log de errores";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de iniciar la transaccion con la fuente de datos para llevar a cabo la operacion deseada";
            var mensajeTecnico = "Se presento una excepción NO CONTROLADA de tipo SQLException tratando de iniciar la conexion con la base de datos. para tener mas detalles, revise el log de errores";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void cancelarTransaccion() throws BackEndException {
        try {
            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.rollback();

        } catch (BackEndException exception) {
            throw exception;

        }catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de cancelar la transaccion con la fuente de datos";
            var mensajeTecnico = "Se presento una excepción de tipo SQLException tratando de cancelar la conexion con la base de datos. para tener mas detalles, revise el log de errores";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de cancelar la transaccion con la fuente de datos";
            var mensajeTecnico = "Se presento una excepción NO CONTROLADA de tipo SQLException tratando de cancelar la conexion con la base de datos. para tener mas detalles, revise el log de errores";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void cerrarConexion() throws BackEndException{
        try {
            asegurarConexionAbierta();
            conexion.close();


        }catch (BackEndException exception){
            throw exception;
        }catch (SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexión con la fuente de datos";
            var mensajeTecnico = "Se presento una excepción de tipo SQLException tratando de cerrar la conexion con la base de datos. para tener mas detalles, revise el log de errores";

             throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de cerrar la conexión con la fuente de datos";
            var mensajeTecnico = "Se presento una excepción NO CONTROLADA de tipo SQLException tratando de cerrar la conexion con la base de datos. para tener mas detalles, revise el log de errores";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    private void asegurarTransaccionIniciada() throws BackEndException {
        if (!transaccionEstaInciada) {
            var mensajeUsuario = "Se ha presentado un problema tratando de gestionar la transaccion con la fuente de datos para llevar a cabo la operacion deseada";
            var mensajeTecnico = "Se intentó gestionar (COMMIT/ROLLBACK) una transaccion que previamente no fué iniciada... ";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico);
        }
    }

    private void asegurarConexionAbierta() throws BackEndException {
        if (!conexionEstaAbierta) {
            var mensajeUsuario = "Se ha presentado un problema tratando llevar a cabo la opearacion deseada con la conexion cerrada...";
            var mensajeTecnico = "Se intentó llevar a cabo una operacion que requería una conexion abierta, pero al momento de validar, está cerrada... ";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico);
        }
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() throws BackEndException{
        asegurarConexionAbierta();
        return new DepartamentoAzureSQLDAO(conexion);
    }

    @Override
    public MunicipioDAO getMunicipioDAO() {
        return new MunicipioAzureSQLDAO(conexion);
    }

    @Override
    public UbicacionPrecisaDAO getUbicacionPrecisaDAO() {
        return new UbicacionPrecisaAzureSQLDAO(conexion);
    }

    @Override
    public TipoCanchaDAO getTipoCanchaDAO() {
        return new TipoCanchaAzureSQLDAO(conexion);
    }


    @Override
    public HorarioDisponibleDAO getHorarioDisponibleDAO() {
        return new HorarioDisponibleAzureSQLDAO(conexion);
    }

    @Override
    public HorarioEspecialDAO getHorarioEspecialDAO() {
        return new HorarioEspecialAzureSQLDAO(conexion);
    }

    @Override
    public EstadoVerificacionDAO getEstadoVerificacionDAO() {
        return new EstadoVerificacionAzureSQLDAO(conexion);
    }

    @Override
    public OrganizacionDeportivaDAO getOrganizacionDeportivaDAO() {
        return new OrganizacionDeportivaAzureSQLDAO(conexion);
    }

    @Override
    public EncargadoDAO getEncargadoDAO() {
        return new EncargadoAzureSQLDAO(conexion);
    }

    @Override
    public CanchaDAO getCanchaDAO() {
        return new CanchaAzureSQLDAO(conexion);
    }

    @Override
    public EstadoReservaDAO getEstadoReservaDAO() {
        return new EstadoReservaAzureSQLDAO(conexion);
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new ClienteAzureSQLDAO(conexion);
    }

    @Override
    public ReservaDAO getReservaDAO() {
        return new ReservaAzureSQLDAO(conexion);
    }

    @Override
    public ResenaDAO getResenaDAO() {
        return new ResenaAzureSQLDAO(conexion);
    }

    @Override
    public FacturaDAO getFacturaDAO() {
        return new FacturaAzureSQLDAO(conexion);
    }

    @Override
    public SuperficieDAO getSuperficieDAO() {
        return new SuperficieAzureSQLDAO(conexion);
    }

    @Override
    public DimensionDAO getDimensionDAO() {
        return new DimensionAzureSQLDAO(conexion);
    }

}
