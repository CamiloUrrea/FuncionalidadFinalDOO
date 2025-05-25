package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.MunicipioDTO;

import java.util.List;
import java.util.UUID;

public interface MunicipioFacade {

    void registrarNuevoMunicipio(UUID departamentoId, MunicipioDTO municipio);

    void modificarMunicipioExistente(UUID departamentoId, UUID municipioId, MunicipioDTO municipio);

    void darBajaDefinitivamenteMunicipioExistente(UUID departamentoId, UUID municipioId);

    MunicipioDTO consultarMunicipioPorId(UUID departamentoId, UUID municipioId);

    List<MunicipioDTO> consultarMunicipios(UUID departamentoID, MunicipioDTO filtro);

}
