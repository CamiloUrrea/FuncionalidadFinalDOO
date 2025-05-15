package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.MunicipioBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.MunicipioDomain;

import java.util.List;
import java.util.UUID;

public class MunicipioBusinessLogicImpl implements MunicipioBusinessLogic {

    @Override
    public void registrarNuevoMunicipio(MunicipioDomain domain) {

    }

    @Override
    public void modificarMunicipioExistente(UUID id, MunicipioDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteMunicipioExistente(UUID id) {

    }

    @Override
    public MunicipioDomain consultarMunicipioPorId(UUID id) {
        return null;
    }

    @Override
    public List<MunicipioDomain> consultarMunicipios(MunicipioDomain filtro) {
        return List.of();
    }
}
