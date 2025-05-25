package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.MunicipioBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.MunicipioBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.MunicipioFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.MunicipioDTO;

import java.util.List;
import java.util.UUID;

public class MunicipioFacadeImpl implements MunicipioFacade {

    private DAOFactory daoFactory;
    private MunicipioBusinessLogic businessLogic;

    public MunicipioFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new MunicipioBusinessLogicImpl(daoFactory);
    }


    @Override
    public void registrarNuevoMunicipio(UUID departamentoId, MunicipioDTO municipio) {

    }

    @Override
    public void modificarMunicipioExistente(UUID departamentoId, UUID municipioId, MunicipioDTO municipio) {

    }

    @Override
    public void darBajaDefinitivamenteMunicipioExistente(UUID departamentoId, UUID municipioId) {

    }

    @Override
    public MunicipioDTO consultarMunicipioPorId(UUID departamentoId, UUID municipioId) {
        return null;
    }

    @Override
    public List<MunicipioDTO> consultarMunicipios(UUID departamentoID, MunicipioDTO filtro) {
        return List.of();
    }
}
