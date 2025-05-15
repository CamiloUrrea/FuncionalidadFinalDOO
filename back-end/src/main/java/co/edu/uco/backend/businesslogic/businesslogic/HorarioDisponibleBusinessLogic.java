package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.HorarioDisponibleDomain;

import java.util.List;
import java.util.UUID;

public interface HorarioDisponibleBusinessLogic {

    void registrarNuevoHorarioDisponible(HorarioDisponibleDomain domain);

    void modificarHorarioDisponibleExistente(UUID id, HorarioDisponibleDomain domain);

    void darBajaDefinitivamenteHorarioDisponibleExistente(UUID id);

    HorarioDisponibleDomain consultarHorarioDisponiblePorId(UUID id);

    List<HorarioDisponibleDomain> consultarHorarioDisponibles(HorarioDisponibleDomain filtro);

}
