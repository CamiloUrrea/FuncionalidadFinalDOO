package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioDisponibleDomain;

import java.util.List;
import java.util.UUID;

public interface HorarioDisponibleBusinessLogic {

    void registrarNuevoHorarioDisponible(UUID canchaId, HorarioDisponibleDomain horarioDisponible);

    void modificarHorarioDisponibleExistente(UUID canchaId,UUID horarioDisponinbleID, HorarioDisponibleDomain horarioDisponible);

    void darBajaDefinitivamenteHorarioDisponibleExistente(UUID canchaId, UUID horarioDisponibleId);

    HorarioDisponibleDomain consultarHorarioDisponiblePorId(UUID canchaId, UUID horarioDisponibleId);

    List<HorarioDisponibleDomain> consultarHorariosDisponiblesPorCancha(UUID canchaId, HorarioDisponibleDomain filtro);

}
