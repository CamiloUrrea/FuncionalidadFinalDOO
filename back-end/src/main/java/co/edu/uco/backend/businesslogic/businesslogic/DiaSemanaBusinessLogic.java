package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.DiaSemanaDomain;

import java.util.List;
import java.util.UUID;

public interface DiaSemanaBusinessLogic {

    void registrarNuevoDiaSemana(DiaSemanaDomain domain);

    void modificarDiaSemanaExistente(UUID id, DiaSemanaDomain domain);

    void darBajaDefinitivamenteDiaSemanaExistente(UUID id);

    DiaSemanaDomain consultarDiaSemanaPorId(UUID id);

    List<DiaSemanaDomain> consultarDiaSemanas(DiaSemanaDomain filtro);

}
