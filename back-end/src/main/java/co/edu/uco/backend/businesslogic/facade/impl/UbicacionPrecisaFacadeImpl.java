package co.edu.uco.backend.businesslogic.facade.impl;

import co.edu.uco.backend.businesslogic.businesslogic.impl.UbicacionPrecisaBusinessLogicImpl;
import co.edu.uco.backend.businesslogic.businesslogic.UbicacionPrecisaBusinessLogic;
import co.edu.uco.backend.businesslogic.facade.UbicacionPrecisaFacade;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.data.dao.factory.Factory;
import co.edu.uco.backend.dto.UbicacionPrecisaDTO;

import java.util.List;
import java.util.UUID;

public class UbicacionPrecisaFacadeImpl implements UbicacionPrecisaFacade {

    private DAOFactory daoFactory;
    private UbicacionPrecisaBusinessLogic businessLogic;

    public UbicacionPrecisaFacadeImpl() throws BackEndException {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        businessLogic = new UbicacionPrecisaBusinessLogicImpl(daoFactory);
    }


    @Override
    public void establecerUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId, UbicacionPrecisaDTO ubicacionPrecisa) {

    }

    @Override
    public void eliminarUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId) {

    }

    @Override
    public UbicacionPrecisaDTO consultarUbicacionPrecisaPorId(UUID canchaId, UUID ubicacionPrecisaId) {
        return null;
    }
}
