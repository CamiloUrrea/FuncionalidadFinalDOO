package co.edu.uco.backend.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

public class DiaSemanaBusinessLogicImpl implements DiaSemanaBusinessLogic {

    @Override
    public void registrarNuevoDiaSemana(DiaSemanaDomain domain) {

    }

    @Override
    public void modificarDiaSemanaExistente(UUID id, DiaSemanaDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteDiaSemanaExistente(UUID id) {

    }

    @Override
    public DiaSemanaDomain consultarDiaSemanaPorId(UUID id) {
        return null;
    }

    @Override
    public List<DiaSemanaDomain> consultarDiaSemanas(DiaSemanaDomain filtro) {
        return List.of();
    }
}
