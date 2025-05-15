package co.edu.uco.backend.data.dao.factory.azuresql;

import co.edu.uco.backend.data.dao.factory.DAOFactory;
import java.sql.Connection;
import co.edu.uco.backend.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.backend.data.dao.entity.departamento.impl.azuresql.DepartamentoAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.municipio.MunicipioDAO;
import co.edu.uco.backend.data.dao.entity.municipio.impl.azuresql.MunicipioAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.UbicacionPrecisaDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.impl.azuresql.UbicacionPrecisaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.TipoCanchaDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.impl.azuresql.TipoCanchaAzureSQLDAO;
import co.edu.uco.backend.data.dao.entity.diasemana.DiaSemanaDAO;
import co.edu.uco.backend.data.dao.entity.diasemana.impl.azuresql.DiaSemanaAzureSQLDAO;
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

public class AzureSQLDAOFactory extends DAOFactory {

    private Connection conexion;

    @Override
    public void abrirConexion() {
        // Implementación de apertura de conexión para Azure SQL
    }

    @Override
    public void iniciarTransacion() {
        // Inicio de transacción
    }

    @Override
    public void confirmarTransacion() {
        // Confirmación de transacción
    }

    @Override
    public void cancelarTransacion() {
        // Cancelación de transacción
    }

    @Override
    public void cerrarConexion() {
        // Cierre de conexión
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
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
    public DiaSemanaDAO getDiaSemanaDAO() {
        return new DiaSemanaAzureSQLDAO(conexion);
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
