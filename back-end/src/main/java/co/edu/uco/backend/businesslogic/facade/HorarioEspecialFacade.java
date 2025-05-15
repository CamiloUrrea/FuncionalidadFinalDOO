package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.HorarioEspecialDTO;

import java.util.List;
import java.util.UUID;

public interface HorarioEspecialFacade {

    void registrarNuevoHorarioEspecial(HorarioEspecialDTO dto);

    void modificarHorarioEspecial(UUID id, HorarioEspecialDTO dto);

    void darBajaDefinitivaHorarioEspecialExistente(UUID id);

    HorarioEspecialDTO consultarHorarioEspecialPorId(UUID id);

    List<HorarioEspecialDTO> consultarHorarioEspecialsPorFiltro(HorarioEspecialDTO filtro);

}
