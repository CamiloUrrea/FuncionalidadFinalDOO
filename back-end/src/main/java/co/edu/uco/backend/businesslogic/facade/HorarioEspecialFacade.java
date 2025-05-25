package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.HorarioEspecialDTO;

import java.util.List;
import java.util.UUID;

public interface HorarioEspecialFacade {

    void registrarNuevoHorarioEspecial(UUID canchaId, HorarioEspecialDTO horarioEspecial);

    void modificarHorarioEspecialExistente(UUID canchaId,UUID horarioEspecialId, HorarioEspecialDTO horarioEspecial);

    void darBajaDefinitivamenteHorarioEspecialExistente(UUID canchaId, UUID horarioEspecialId);

    HorarioEspecialDTO consultarHorarioEspecialPorId(UUID canchaId, UUID horarioEspecialId);

    List<HorarioEspecialDTO> consultarHorariosEspecialesPorCancha(UUID canchaId, HorarioEspecialDTO horarioEspecial);

}
