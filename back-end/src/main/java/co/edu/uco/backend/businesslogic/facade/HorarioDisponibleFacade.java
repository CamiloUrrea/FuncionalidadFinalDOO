package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.HorarioDisponibleDTO;

import java.util.List;
import java.util.UUID;

public interface HorarioDisponibleFacade {

    void registrarNuevoHorarioDisponible(UUID canchaId, HorarioDisponibleDTO horarioDisponible);

    void modificarHorarioDisponibleExistente(UUID canchaId,UUID horarioDisponinbleID, HorarioDisponibleDTO horarioDisponible);

    void darBajaDefinitivamenteHorarioDisponibleExistente(UUID canchaId, UUID horarioDisponibleId);

    HorarioDisponibleDTO consultarHorarioDisponiblePorId(UUID canchaId, UUID horarioDisponibleId);

    List<HorarioDisponibleDTO> consultarHorariosDisponiblesPorCancha(UUID canchaId, HorarioDisponibleDTO filtro);

}
