package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.UbicacionPrecisaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UbicacionPrecisaDomain;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.entity.UbicacionPrecisaEntity;

import java.util.List;
import java.util.UUID;

public class UbicacionPrecisaBusinessLogicImpl implements UbicacionPrecisaBusinessLogic {

    private DAOFactory factory;
    public UbicacionPrecisaBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void establecerUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId, UbicacionPrecisaDomain ubicacionPrecisa) {
        //TODO: Mapear con upsert y validar cancha
    }

    @Override
    public void eliminarUbicacionPrecisa(UUID canchaId, UUID ubicacionPrecisaId) throws BackEndException {
        UbicacionPrecisaEntity ubicacionPrecisaEntity = null;
        //TODO: Validar cancha
        factory.getUbicacionPrecisaDAO().crear(ubicacionPrecisaEntity);
    }

    @Override
    public UbicacionPrecisaDomain consultarUbicacionPrecisaPorId(UUID canchaId, UUID ubicacionPrecisaId) throws BackEndException {
        UbicacionPrecisaEntity ubicacionPrecisaEntity = null;
        //TODO: mapear de Entity -> Domain y validar cancha
        factory.getUbicacionPrecisaDAO().consultarPorId(ubicacionPrecisaId);
        return null;
    }

}
