package co.edu.uco.backend.businesslogic.businesslogic;

import co.edu.uco.backend.businesslogic.businesslogic.domain.MunicipioDomain;

import java.util.List;
import java.util.UUID;

public interface MunicipioBusinessLogic {

    void registrarNuevoMunicipio(UUID departamentoId, MunicipioDomain domain);

    void modificarMunicipioExistente(UUID departamentoId, UUID municipioId, MunicipioDomain domain);

    void darBajaDefinitivamenteMunicipioExistente(UUID departamentoId, UUID municipioId);

    MunicipioDomain consultarMunicipioPorId(UUID departamentoId, UUID municipioId);

    List<MunicipioDomain> consultarMunicipios(UUID departamentoID, MunicipioDomain filtro);

}
