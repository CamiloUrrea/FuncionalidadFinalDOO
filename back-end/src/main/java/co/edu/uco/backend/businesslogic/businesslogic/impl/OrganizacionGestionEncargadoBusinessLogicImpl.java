package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.businesslogic.OrganizacionGestionEncargadoBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.EncargadoDomain;
import co.edu.uco.backend.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class OrganizacionGestionEncargadoBusinessLogicImpl implements OrganizacionGestionEncargadoBusinessLogic {


    public OrganizacionGestionEncargadoBusinessLogicImpl(DAOFactory daoFactory) {
    }

    @Override
    public void registrarNuevoEncargado(UUID orgId, EncargadoDomain domain) {

    }

    @Override
    public void modificarEncargadoExistente(UUID orgid, EncargadoDomain domain) {

    }

    @Override
    public void darBajaDefinitivamenteEncargadoExistente(UUID orgId, UUID encargadoId) {

    }


    @Override
    public List<EncargadoDomain> consultarMisEncargados(UUID orgId, EncargadoDomain filtro) {
        return List.of();
    }


}
