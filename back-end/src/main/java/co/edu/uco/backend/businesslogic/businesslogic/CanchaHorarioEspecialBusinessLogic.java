package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioEspecialDomain;

import java.util.List;
import java.util.UUID;

public interface CanchaHorarioEspecialBusinessLogic {

    void registrarNuevoHorarioEspecial(UUID canchaId, HorarioEspecialDomain horarioEspecial);

    void modificarHorarioEspecialExistente(UUID canchaId, HorarioEspecialDomain horarioEspecial);

    void darBajaDefinitivamenteHorarioEspecialExistente(UUID canchaId, UUID horarioEspecialId);

    List<HorarioEspecialDomain> consultarHorariosEspeciales(UUID canchaId);

}
