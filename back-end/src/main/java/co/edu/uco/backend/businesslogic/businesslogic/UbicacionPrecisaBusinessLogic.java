package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.UbicacionPrecisaDomain;

import java.util.List;
import java.util.UUID;

public interface UbicacionPrecisaBusinessLogic {

    void registrarNuevoUbicacionPrecisa(UbicacionPrecisaDomain domain);

    void modificarUbicacionPrecisaExistente(UUID id, UbicacionPrecisaDomain domain);

    void darBajaDefinitivamenteUbicacionPrecisaExistente(UUID id);

    UbicacionPrecisaDomain consultarUbicacionPrecisaPorId(UUID id);

    List<UbicacionPrecisaDomain> consultarUbicacionPrecisas(UbicacionPrecisaDomain filtro);

}
