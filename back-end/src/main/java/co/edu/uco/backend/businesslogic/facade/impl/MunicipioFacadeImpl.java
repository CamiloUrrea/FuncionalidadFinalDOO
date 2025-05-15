package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.MunicipioBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.MunicipioBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.MunicipioFacade;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.MunicipioDTO;

import java.util.List;
import java.util.UUID;

public class MunicipioFacadeImpl implements MunicipioFacade {

    private DAOFactory daoFactory;
    private MunicipioBusinessLogic businessLogic;

    public MunicipioFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new MunicipioBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoMunicipio(MunicipioDTO dto) {

    }

    @Override
    public void modificarMunicipio(UUID id, MunicipioDTO dto) {

    }

    @Override
    public void darBajaDefinitivaMunicipioExistente(UUID id) {

    }

    @Override
    public MunicipioDTO consultarMunicipioPorId(UUID id) {
        return null;
    }

    @Override
    public List<MunicipioDTO> consultarMunicipiosPorFiltro(MunicipioDTO filtro) {
        return List.of();
    }
}
