package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.ResenaBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ResenaDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class ResenaBusinessLogicImpl implements ResenaBusinessLogic {

    public ResenaBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoResena(UUID reserva, ResenaDomain resena) {

    }

    @Override
    public void modificarResenaExistente(UUID reservaId, UUID resenaId, ResenaDomain resena) {

    }

    @Override
    public void darBajaDefinitivamenteResenaExistente(UUID reservaId, UUID resenaId) {

    }

    @Override
    public ResenaDomain consultarResenaPorReserva(UUID reservaId, UUID resenaId) {
        return null;
    }

    @Override
    public List<ResenaDomain> consultarResenas(UUID reservaId, ResenaDomain filtro) {
        return List.of();
    }
}
