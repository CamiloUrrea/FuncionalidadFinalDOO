package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.HorarioDisponibleDTO;

import java.util.List;
import java.util.UUID;

public interface HorarioDisponibleFacade {

    void registrarNuevoHorarioDisponible(HorarioDisponibleDTO dto);

    void modificarHorarioDisponible(UUID id, HorarioDisponibleDTO dto);

    void darBajaDefinitivaHorarioDisponibleExistente(UUID id);

    HorarioDisponibleDTO consultarHorarioDisponiblePorId(UUID id);

    List<HorarioDisponibleDTO> consultarHorarioDisponiblesPorFiltro(HorarioDisponibleDTO filtro);

}
