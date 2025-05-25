package co.edu.uco.backend.data.dao.factory.postgresql;

import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.DataBackEndException;
import co.edu.uco.backend.data.dao.entity.cancha.impl.azuresql.CanchaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.cliente.impl.azuresql.ClienteAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.departamento.impl.azuresql.DepartamentoAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.dimension.impl.azuresql.DimensionAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.encargado.impl.azuresql.EncargadoAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.estadoreserva.impl.azuresql.EstadoReservaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.estadoverificacion.impl.azuresql.EstadoVerificacionAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.factura.impl.azuresql.FacturaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.horariodisponible.impl.azuresql.HorarioDisponibleAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.horarioespecial.impl.azuresql.HorarioEspecialAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.municipio.impl.azuresql.MunicipioAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.impl.azuresql.OrganizacionDeportivaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.resena.impl.azuresql.ResenaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.reserva.impl.azuresql.ReservaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.superficie.impl.azuresql.SuperficieAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.impl.azuresql.TipoCanchaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.impl.azuresql.UbicacionPrecisaAzureSQLDAO;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.backend.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.backend.data.dao.entity.municipio.MunicipioDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.UbicacionPrecisaDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.TipoCanchaDAO;

import co.edu.uco.backend.data.dao.entity.horariodisponible.HorarioDisponibleDAO;
import co.edu.uco.backend.data.dao.entity.horarioespecial.HorarioEspecialDAO;
import co.edu.uco.backend.data.dao.entity.estadoverificacion.EstadoVerificacionDAO;
import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.OrganizacionDeportivaDAO;
import co.edu.uco.backend.data.dao.entity.encargado.EncargadoDAO;
import co.edu.uco.backend.data.dao.entity.cancha.CanchaDAO;
import co.edu.uco.backend.data.dao.entity.estadoreserva.EstadoReservaDAO;
import co.edu.uco.backend.data.dao.entity.cliente.ClienteDAO;
import co.edu.uco.backend.data.dao.entity.reserva.ReservaDAO;
import co.edu.uco.backend.data.dao.entity.resena.ResenaDAO;
import co.edu.uco.backend.data.dao.entity.factura.FacturaDAO;
import co.edu.uco.backend.data.dao.entity.superficie.SuperficieDAO;
import co.edu.uco.backend.data.dao.entity.dimension.DimensionDAO;

public abstract class PostgreSQLDAOFactory extends DAOFactory {

    private Connection conexion;
    private boolean transaccionEstaIniciada = false;
    private boolean connexionEstaAbierta = false;

    protected PostgreSQLDAOFactory() throws BackEndException {
        transaccionEstaIniciada = false;
        connexionEstaAbierta = false;
        abrirConexion();
    }



    @Override
    public void abrirConexion() throws BackEndException {
        var baseDatos = "DOODB";
        var servidor = "localhost:5432";

        try {
            conexion=DriverManager.getConnection("jdbc:postgresql://" + servidor + "/" + baseDatos);
            connexionEstaAbierta = true;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de obtener la conexión con la base de datos "
                    + baseDatos + " en el servidor " + servidor + ", para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de obtener la conexión con la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de obtener la conexión con la base de datos "
                    + baseDatos + " en el servidor " + servidor + ", para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de obtener la conexión con la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void iniciartransaccion() throws BackEndException {
        try {
            asegurarConexionAbierta();
            conexion.setAutoCommit(false);
            transaccionEstaIniciada =true;

        } catch (BackEndException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de iniciar la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de iniciar la transacción con la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de iniciar la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de iniciar la transacción con la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void confirmartransaccion() throws BackEndException {
        try {

            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.commit();
            conexion.setAutoCommit(true);
            transaccionEstaIniciada = false;

        } catch (BackEndException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de CONFIRMAR la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de confirmar la transacción con la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONFIRMAR la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de confirmar la transacción con la fuente de datos";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void cancelartransaccion() throws BackEndException {
        try {
            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.rollback();
            conexion.setAutoCommit(true);
            transaccionEstaIniciada = false;

        } catch (BackEndException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de CANCELAR la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de cancelar la transacción con la fuente de datos para revertir la operación realizada";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CANCELAR la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de cancelar la transacción con la fuente de datos para revertir la operación realizada";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void cerrarConexion() throws BackEndException {
        try {
            asegurarConexionAbierta();
            conexion.close();
            connexionEstaAbierta = false;

        } catch (BackEndException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de CERRAR la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexión con la fuente de datos luego de realizar la operación";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CERRAR la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de cerrar la conexión con la fuente de datos luego de realizar la operación";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    private void asegurarTransaccionIniciada() throws BackEndException {
        if (!transaccionEstaIniciada) {
            var mensajeTecnico = "Se presentó una excepción tratando de gestionar(COMMIT,ROLLBACK) la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de gestionar la conexión con la fuente de datos luego de realizar la operación";

            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico);
        }
    }

    private void asegurarConexionAbierta() throws BackEndException {
        if (!connexionEstaAbierta) {
            var mensajeTecnico = "Se intentó llevar a cabo una operación que requería una conexión abierta, pero al momento de validarla esta cerrada";
            var mensajeUsuario = "Se presentó una excepción tratando de llevar a cabo operación deseada con la conexión cerrada";

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

