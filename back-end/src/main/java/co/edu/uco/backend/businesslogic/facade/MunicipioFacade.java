package co.edu.uco.backend.businesslogic.facade;

import co.edu.uco.backend.dto.MunicipioDTO;

import java.util.List;
import java.util.UUID;

public interface MunicipioFacade {

    void registrarNuevoMunicipio(MunicipioDTO dto);

    void modificarMunicipio(UUID id, MunicipioDTO dto);

    void darBajaDefinitivaMunicipioExistente(UUID id);

    MunicipioDTO consultarMunicipioPorId(UUID id);

    List<MunicipioDTO> consultarMunicipiosPorFiltro(MunicipioDTO filtro);

}
