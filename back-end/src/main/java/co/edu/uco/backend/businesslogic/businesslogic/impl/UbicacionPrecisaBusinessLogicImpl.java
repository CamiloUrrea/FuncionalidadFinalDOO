package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.UbicacionPrecisaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UbicacionPrecisaDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class UbicacionPrecisaBusinessLogicImpl implements UbicacionPrecisaBusinessLogic {


    public UbicacionPrecisaBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void establecerUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId, UbicacionPrecisaDomain ubicacionPrecisa) {

    }

    @Override
    public void eliminarUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId) {

    }

    @Override
    public UbicacionPrecisaDomain consultarUbicacionPrecisaPorId(UUID canchaId, UUID ubicacionPrecisaId) {
        return null;
    }

    @Override
    public UbicacionPrecisaDomain consultarUbicacionPrecisaPorCancha(UUID canchaId, UbicacionPrecisaDomain filtro) {
        return null;
    }
}
