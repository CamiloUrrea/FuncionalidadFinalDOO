package co.edu.uco.backend.businesslogic.assembler;

import java.util.List;

public interface DTOAssembler <E, D> {
    E toEntity(D domain);

    D toDomain(E entity);

    List<D> toDomains(List<E> entities);

    List<E> toEntities(List<D> domains);
}
