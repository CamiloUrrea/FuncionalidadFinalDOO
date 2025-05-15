package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.EncargadoBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.EncargadoDomain;

import java.util.List;
import java.util.UUID;

public class EncargadoBusinessLogicImpl implements EncargadoBusinessLogic {

    @Override
    public void registrarNuevoEncargado(EncargadoDomain domain) {

    }

    @Override
    public void modificarEncargadoExistente(UUID id, EncargadoDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteEncargadoExistente(UUID id) {

    }

    @Override
    public EncargadoDomain consultarEncargadoPorId(UUID id) {
        return null;
    }

    @Override
    public List<EncargadoDomain> consultarEncargados(EncargadoDomain filtro) {
        return List.of();
    }
}
