package co.edu.uco.backend.data.dao.entity.estadoverificacion.impl.postgresql;

import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.DataBackEndException;
import co.edu.uco.backend.data.dao.entity.estadoverificacion.EstadoVerificacionDAO;
import co.edu.uco.backend.entity.EstadoVerificacionEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EstadoVerificacionPostgreSQLDAO implements EstadoVerificacionDAO {

    private final Connection connection;

    public EstadoVerificacionPostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(EstadoVerificacionEntity entity) throws BackEndException {
        var sql = new StringBuilder();
        sql.append("INSERT INTO doodb.estado_verificacion(id, nombre) VALUES (?, ?)");
        try (PreparedStatement pst = connection.prepareStatement(sql.toString())) {
            pst.setObject(1, entity.getId());
            pst.setString(2, entity.getNombre());
            pst.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "SQLException al registrar EstadoVerificacion en la base de datos.";
            var mensajeUsuario = "No se pudo registrar el estado de verificación. Intenta de nuevo más tarde.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Excepción NO CONTROLADA al registrar EstadoVerificacion.";
            var mensajeUsuario = "Error inesperado al registrar el estado de verificación.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void eliminar(UUID id) throws BackEndException {
        var sql = new StringBuilder();
        sql.append("DELETE FROM doodb.estado_verificacion WHERE id = ?");
        try (PreparedStatement pst = connection.prepareStatement(sql.toString())) {
            pst.setObject(1, id);
            pst.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "SQLException al eliminar EstadoVerificacion en la base de datos.";
            var mensajeUsuario = "No se pudo eliminar el estado de verificación. Intenta de nuevo.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Excepción NO CONTROLADA al eliminar EstadoVerificacion.";
            var mensajeUsuario = "Error inesperado al eliminar el estado de verificación.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<EstadoVerificacionEntity> consultar(EstadoVerificacionEntity filtro) throws BackEndException {
        var lista = new ArrayList<EstadoVerificacionEntity>();
        var sql = new StringBuilder();
        sql.append("SELECT id, nombre FROM doodb.estado_verificacion WHERE 1=1");

        boolean filtrarId    = filtro != null && filtro.getId() != null;
        boolean filtrarNombre = filtro != null && filtro.getNombre() != null && !filtro.getNombre().isBlank();

        if (filtrarId) {
            sql.append(" AND id = ?");
        }
        if (filtrarNombre) {
            sql.append(" AND nombre ILIKE ?");
        }

        try (PreparedStatement pst = connection.prepareStatement(sql.toString())) {
            int idx = 1;
            if (filtrarId) {
                pst.setObject(idx++, filtro.getId());
            }
            if (filtrarNombre) {
                pst.setString(idx++, "%" + filtro.getNombre().trim() + "%");
            }
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    var entidad = new EstadoVerificacionEntity(
                            (UUID) rs.getObject("id"),
                            rs.getString("nombre")
                    );
                    lista.add(entidad);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "SQLException al consultar estados de verificación.";
            var mensajeUsuario = "No se pudo obtener los estados de verificación.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Excepción NO CONTROLADA al consultar estados de verificación.";
            var mensajeUsuario = "Error inesperado al consultar los estados de verificación.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return lista;
    }

    @Override
    public EstadoVerificacionEntity consultarPorId(UUID id) throws BackEndException {
        var sql = new StringBuilder();
        sql.append("SELECT id, nombre FROM doodb.estado_verificacion WHERE id = ?");
        try (PreparedStatement pst = connection.prepareStatement(sql.toString())) {
            pst.setObject(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new EstadoVerificacionEntity(
                            (UUID) rs.getObject("id"),
                            rs.getString("nombre")
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "SQLException al consultar EstadoVerificacion por ID.";
            var mensajeUsuario = "No se encontró el estado de verificación solicitado.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Excepción NO CONTROLADA al consultar EstadoVerificacion por ID.";
            var mensajeUsuario = "Error inesperado al buscar el estado de verificación.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void modificar(UUID id, EstadoVerificacionEntity entity) throws BackEndException {
        var sql = new StringBuilder();
        sql.append("UPDATE doodb.estado_verificacion SET nombre = ? WHERE id = ?");
        try (PreparedStatement pst = connection.prepareStatement(sql.toString())) {
            pst.setString(1, entity.getNombre());
            pst.setObject(2, id);
            pst.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "SQLException al modificar EstadoVerificacion.";
            var mensajeUsuario = "No se pudo actualizar el estado de verificación.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Excepción NO CONTROLADA al modificar EstadoVerificacion.";
            var mensajeUsuario = "Error inesperado al actualizar el estado de verificación.";
            throw DataBackEndException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public Optional<UUID> findIdByNombre(String nombre) throws BackEndException {
        var sql = "SELECT id FROM doodb.estado_verificacion WHERE nombre = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, nombre);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return Optional.of((UUID) rs.getObject("id"));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException exception) {
            throw new BackEndException("Error al buscar el UUID del estado por nombre.", exception);
        }
    }
}
