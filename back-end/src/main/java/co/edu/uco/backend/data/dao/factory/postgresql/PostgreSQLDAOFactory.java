package co.edu.uco.backend.data.dao.factory.postgresql;

import co.edu.uco.backend.data.dao.factory.DAOFactory;
import java.sql.Connection;

import co.edu.uco.backend.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.backend.data.dao.entity.departamento.impl.postgresql.DepartamentoPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.municipio.MunicipioDAO;
import co.edu.uco.backend.data.dao.entity.municipio.impl.postgresql.MunicipioPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.UbicacionPrecisaDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.impl.postgresql.UbicacionPrecisaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.TipoCanchaDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.impl.postgresql.TipoCanchaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.diasemana.DiaSemanaDAO;
import co.edu.uco.backend.data.dao.entity.diasemana.impl.postgresql.DiaSemanaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.horariodisponible.HorarioDisponibleDAO;
import co.edu.uco.backend.data.dao.entity.horariodisponible.impl.postgresql.HorarioDisponiblePostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.horarioespecial.HorarioEspecialDAO;
import co.edu.uco.backend.data.dao.entity.horarioespecial.impl.postgresql.HorarioEspecialPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.estadoverificacion.EstadoVerificacionDAO;
import co.edu.uco.backend.data.dao.entity.estadoverificacion.impl.postgresql.EstadoVerificacionPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.OrganizacionDeportivaDAO;
import co.edu.uco.backend.data.dao.entity.organizaciondeportiva.impl.postgresql.OrganizacionDeportivaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.encargado.EncargadoDAO;
import co.edu.uco.backend.data.dao.entity.encargado.impl.postgresql.EncargadoPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.cancha.CanchaDAO;
import co.edu.uco.backend.data.dao.entity.cancha.impl.postgresql.CanchaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.estadoreserva.EstadoReservaDAO;
import co.edu.uco.backend.data.dao.entity.estadoreserva.impl.postgresql.EstadoReservaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.cliente.ClienteDAO;
import co.edu.uco.backend.data.dao.entity.cliente.impl.postgresql.ClientePostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.reserva.ReservaDAO;
import co.edu.uco.backend.data.dao.entity.reserva.impl.postgresql.ReservaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.resena.ResenaDAO;
import co.edu.uco.backend.data.dao.entity.resena.impl.postgresql.ResenaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.factura.FacturaDAO;
import co.edu.uco.backend.data.dao.entity.factura.impl.postgresql.FacturaPostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.superficie.SuperficieDAO;
import co.edu.uco.backend.data.dao.entity.superficie.impl.postgresql.SuperficiePostgreSQLDAO;
import co.edu.uco.backend.data.dao.entity.dimension.DimensionDAO;
import co.edu.uco.backend.data.dao.entity.dimension.impl.postgresql.DimensionPostgreSQLDAO;

public class PostgreSQLDAOFactory extends DAOFactory {

    private Connection conexion;

    public PostgreSQLDAOFactory() {
        abrirConexion();
    }

    @Override
    protected void abrirConexion() {
        conexion = null; // Aquí deberías abrir la conexión real a PostgreSQL
    }

    @Override
    public void iniciarTransacion() {}

    @Override
    public void confirmarTransacion() {}

    @Override
    public void cancelarTransacion() {}

    @Override
    public void cerrarConexion() {}

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoPostgreSQLDAO(conexion);
    }

    @Override
    public MunicipioDAO getMunicipioDAO() {
        return new MunicipioPostgreSQLDAO(conexion);
    }

    @Override
    public UbicacionPrecisaDAO getUbicacionPrecisaDAO() {
        return new UbicacionPrecisaPostgreSQLDAO(conexion);
    }

    @Override
    public TipoCanchaDAO getTipoCanchaDAO() {
        return new TipoCanchaPostgreSQLDAO(conexion);
    }

    @Override
    public DiaSemanaDAO getDiaSemanaDAO() {
        return new DiaSemanaPostgreSQLDAO(conexion);
    }

    @Override
    public HorarioDisponibleDAO getHorarioDisponibleDAO() {
        return new HorarioDisponiblePostgreSQLDAO(conexion);
    }

    @Override
    public HorarioEspecialDAO getHorarioEspecialDAO() {
        return new HorarioEspecialPostgreSQLDAO(conexion);
    }

    @Override
    public EstadoVerificacionDAO getEstadoVerificacionDAO() {
        return new EstadoVerificacionPostgreSQLDAO(conexion);
    }

    @Override
    public OrganizacionDeportivaDAO getOrganizacionDeportivaDAO() {
        return new OrganizacionDeportivaPostgreSQLDAO(conexion);
    }

    @Override
    public EncargadoDAO getEncargadoDAO() {
        return new EncargadoPostgreSQLDAO(conexion);
    }

    @Override
    public CanchaDAO getCanchaDAO() {
        return new CanchaPostgreSQLDAO(conexion);
    }

    @Override
    public EstadoReservaDAO getEstadoReservaDAO() {
        return new EstadoReservaPostgreSQLDAO(conexion);
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new ClientePostgreSQLDAO(conexion);
    }

    @Override
    public ReservaDAO getReservaDAO() {
        return new ReservaPostgreSQLDAO(conexion);
    }

    @Override
    public ResenaDAO getResenaDAO() {
        return new ResenaPostgreSQLDAO(conexion);
    }

    @Override
    public FacturaDAO getFacturaDAO() {
        return new FacturaPostgreSQLDAO(conexion);
    }

    @Override
    public SuperficieDAO getSuperficieDAO() {
        return new SuperficiePostgreSQLDAO(conexion);
    }

    @Override
    public DimensionDAO getDimensionDAO() {
        return new DimensionPostgreSQLDAO(conexion);
    }

}
