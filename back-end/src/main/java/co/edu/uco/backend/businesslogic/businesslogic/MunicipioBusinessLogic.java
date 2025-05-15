package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.MunicipioDomain;

import java.util.List;
import java.util.UUID;

public interface MunicipioBusinessLogic {

    void registrarNuevoMunicipio(MunicipioDomain domain);

    void modificarMunicipioExistente(UUID id, MunicipioDomain domain);

    void darBajaDefinitivamenteMunicipioExistente(UUID id);

    MunicipioDomain consultarMunicipioPorId(UUID id);

    List<MunicipioDomain> consultarMunicipios(MunicipioDomain filtro);

}
