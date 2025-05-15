package co.edu.uco.backend.data.dao.factory;

import co.edu.uco.backend.data.dao.factory.postgresql.PostgreSQLDAOFactory;
import co.edu.uco.backend.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.backend.data.dao.entity.municipio.MunicipioDAO;
import co.edu.uco.backend.data.dao.entity.ubicacionprecisa.UbicacionPrecisaDAO;
import co.edu.uco.backend.data.dao.entity.tipocancha.TipoCanchaDAO;
import co.edu.uco.backend.data.dao.entity.diasemana.DiaSemanaDAO;
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

public abstract class DAOFactory {

    public static DAOFactory getFactory(Factory factory) {
        switch (factory) {
            case POSTGRE_SQL:
                return new PostgreSQLDAOFactory();
            default:
                throw new IllegalArgumentException("Unexpected value: " + factory);
        }
    }

    protected abstract void abrirConexion();

    public abstract void iniciarTransacion();

    public abstract void confirmarTransacion();

    public abstract void cancelarTransacion();

    public abstract void cerrarConexion();

    public abstract DepartamentoDAO getDepartamentoDAO();
    public abstract MunicipioDAO getMunicipioDAO();
    public abstract UbicacionPrecisaDAO getUbicacionPrecisaDAO();
    public abstract TipoCanchaDAO getTipoCanchaDAO();
    public abstract DiaSemanaDAO getDiaSemanaDAO();
    public abstract HorarioDisponibleDAO getHorarioDisponibleDAO();
    public abstract HorarioEspecialDAO getHorarioEspecialDAO();
    public abstract EstadoVerificacionDAO getEstadoVerificacionDAO();
    public abstract OrganizacionDeportivaDAO getOrganizacionDeportivaDAO();
    public abstract EncargadoDAO getEncargadoDAO();
    public abstract CanchaDAO getCanchaDAO();
    public abstract EstadoReservaDAO getEstadoReservaDAO();
    public abstract ClienteDAO getClienteDAO();
    public abstract ReservaDAO getReservaDAO();
    public abstract ResenaDAO getResenaDAO();
    public abstract FacturaDAO getFacturaDAO();
    public abstract SuperficieDAO getSuperficieDAO();
    public abstract DimensionDAO getDimensionDAO();

}
