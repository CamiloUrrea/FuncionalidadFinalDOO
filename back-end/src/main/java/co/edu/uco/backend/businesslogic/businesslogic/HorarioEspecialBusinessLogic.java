package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioEspecialDomain;

import java.util.List;
import java.util.UUID;

public interface HorarioEspecialBusinessLogic {

    void registrarNuevoHorarioEspecial(HorarioEspecialDomain domain);

    void modificarHorarioEspecialExistente(UUID id, HorarioEspecialDomain domain);

    void darBajaDefinitivamenteHorarioEspecialExistente(UUID id);

    HorarioEspecialDomain consultarHorarioEspecialPorId(UUID id);

    List<HorarioEspecialDomain> consultarHorarioEspecials(HorarioEspecialDomain filtro);

}
