package co.edu.uco.backend.data.dao.entity;

import java.util.List;

public interface RetrieveDAO<E, ID> {
    List<E> consultar(E filtro);
    E consultarPorId(ID id);
}
