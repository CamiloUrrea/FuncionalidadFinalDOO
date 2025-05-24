package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioEspecialDomain;

import java.util.List;
import java.util.UUID;

public interface HorarioEspecialBusinessLogic {

    void registrarNuevoHorarioEspecial(UUID canchaId, HorarioEspecialDomain horarioEspecial);

    void modificarHorarioEspecialExistente(UUID canchaId,UUID horarioEspecialId, HorarioEspecialDomain horarioEspecial);

    void darBajaDefinitivamenteHorarioEspecialExistente(UUID canchaId, UUID horarioEspecialId);

    HorarioEspecialDomain consultarHorarioEspecialPorId(UUID canchaId, UUID horarioEspecialId);

    List<HorarioEspecialDomain> consultarHorariosEspecialesPorCancha(UUID canchaId);

}
