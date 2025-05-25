package co.edu.uco.backend.data.dao.entity;

public interface UpdateDAO<E, ID> {
    void modificar(ID id, E entity);
}
