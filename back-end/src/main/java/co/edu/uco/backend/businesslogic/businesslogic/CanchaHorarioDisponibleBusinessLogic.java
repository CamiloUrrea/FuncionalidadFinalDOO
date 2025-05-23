package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.DiaSemanaDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioDisponibleDomain;

import java.util.List;
import java.util.UUID;

public interface CanchaHorarioDisponibleBusinessLogic {

    void registrarNuevoHorarioDisponible(UUID canchaId, HorarioDisponibleDomain horarioDisponible);

    void modificarHorarioDisponibleExistente(UUID canchaId, HorarioDisponibleDomain horarioDisponible);

    void darBajaDefinitivamenteHorarioDisponibleExistente(UUID canchaId, UUID horarioDisponibleId);

    List<HorarioDisponibleDomain> consultarHorariosDisponibles(UUID canchaId, DiaSemanaDomain diaSemana);

}
