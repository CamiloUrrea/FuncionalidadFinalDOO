package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.MunicipioBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.MunicipioDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class MunicipioBusinessLogicImpl implements MunicipioBusinessLogic {

    public MunicipioBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoMunicipio(UUID departamentoId, MunicipioDomain municipio) {

    }

    @Override
    public void modificarMunicipioExistente(UUID departamentoId, UUID municipioId, MunicipioDomain municipio) {

    }

    @Override
    public void darBajaDefinitivamenteMunicipioExistente(UUID departamentoId, UUID municipioId) {

    }

    @Override
    public MunicipioDomain consultarMunicipioPorId(UUID departamentoId, UUID municipioId) {
        return null;
    }

    @Override
    public List<MunicipioDomain> consultarMunicipios(UUID departamentoID, MunicipioDomain filtro) {
        return List.of();
    }
}
