package co.edu.uco.backend.businesslogic.businesslogic.impl;

import co.edu.uco.backend.businesslogic.assembler.cliente.entity.ClienteEntityAssembler;
import co.edu.uco.backend.businesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.backend.businesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.backend.businesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.backend.crosscutting.exceptions.BackEndException;
import co.edu.uco.backend.crosscutting.exceptions.BusinessLogicBackEndException;
import co.edu.uco.backend.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.backend.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.backend.data.dao.factory.DAOFactory;
import co.edu.uco.backend.entity.ClienteEntity;

import java.util.List;
import java.util.UUID;


public class ClienteBusinessLogicImpl implements ClienteBusinessLogic {

    private final DAOFactory factory;
    public ClienteBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevoCliente(ClienteDomain cliente) throws BackEndException {
        //  1. POL-0001. Asegurar que el número de celular sea único en el sistema
        validarNoExistaClienteCoMismoTelefono(cliente.getTelefono());
        //  2. POL-0002. Asegurar que no existe otro Cliente con el mismo nombre de usuario.
        validarNoExistaClienteConMismoUsername(cliente.getUsername());
        //  TODO: 3. POL-0003. Validar el número telefónico del cliente, con un código enviado antes de activar la cuenta

        //  4. POL-0004. Asegurar que los datos requeridos para llevar a cabo la acción sean válidos a nivel de tipo de dato,
        //  longitud, obligatoriedad, formato y rango.
        validarIntegridadInformacionRegistrarNuevoCliente(cliente);

        //  5. Generar id de nuevo cliente
        var id = generarIdentificadorNuevoCliente();

        //  6. Recrear el domain con el id generado
        var clienteDomainACrear = new ClienteDomain(id,cliente.getNombre(),cliente.getUsername(),cliente.getContrasena(),cliente.getPrefijoTelefono(),cliente.getTelefono());

        //  7. Creamos el cliente siempre y cuando se cumplan todas las reglas
        ClienteEntity clienteEntity = ClienteEntityAssembler.getInstance().toEntity(clienteDomainACrear);
        factory.getClienteDAO().crear(clienteEntity);
    }

    private void validarIntegridadInformacionRegistrarNuevoCliente(ClienteDomain cliente) throws BackEndException {
        validarIntegridadNombreCliente(cliente.getNombre());
        validarIntegridadUsernameCliente(cliente.getUsername());
        validarIntegridadContrasena(cliente.getContrasena());
        validarIntegridadPrefijo(cliente.getPrefijoTelefono());
        validarIntegridadTelefono(cliente.getTelefono());
    }

    private void validarIntegridadNombreCliente(String nombre) throws BackEndException {
        //  1. Obligatoriedad: El nombre debe ser obligatorio
        if(UtilTexto.getInstance().estaVacia(nombre)) {
            throw BusinessLogicBackEndException.reportar("El nombre del cliente es un dato obligatorio");
        }

        //  2. Longitud: entre 2 y 100 caracteres
        var util = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
        if(util.length() > 100 || util.length() <2){
            throw BusinessLogicBackEndException.reportar("El nombre del cliente debe tener entre 2 y 100 caracteres");
        }

        //  3. Formato: Solo texto sin números
        if (!UtilTexto.getInstance().contieneSoloLetrasEspacios(nombre)) {
            throw BusinessLogicBackEndException.reportar(
                    "El nombre del cliente solo puede contener letras y espacios"
            );
        }
    }

    private void validarIntegridadUsernameCliente(String username) throws BackEndException {
        //  1. Obligatoriedad: El nombre de usuario debe ser obligatorio
        if(UtilTexto.getInstance().estaVacia(username)) {
            throw BusinessLogicBackEndException.reportar("El nombre de usuario es un dato obligatorio");
        }

        //  2. Longitud: Entre 5 y 30 caracteres
        var util = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(username);
        if(util.length() > 30 || util.length() <5){
            throw BusinessLogicBackEndException.reportar("El nombre del usuario debe tener entre 5 y 30 caracteres");
        }

        //  3. Formato: Solo texto sin números
        if (!UtilTexto.getInstance().contieneSoloLetrasNumerosEspacios(username)) {
            throw BusinessLogicBackEndException.reportar(
                    "El nombre de usuario solo puede contener letras, numeros y espacios"
            );
        }
    }

    private void validarIntegridadContrasena(String contrasena) throws BackEndException {
        //  1. Obligatoriedad: La contraseña debe ser obligatoria
        if(UtilTexto.getInstance().estaVacia(contrasena)) {
            throw BusinessLogicBackEndException.reportar("La contraseña es un dato obligatorio");
        }

        //  2. Longitud: Entre 8 y 24 caracteres
        var util = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(contrasena);
        if(util.length() > 24 || util.length() <8){
            throw BusinessLogicBackEndException.reportar("La contraseña debe tener entre 8 y 24 caracteres");
        }

        //  3. Formato: Solo texto sin números
        if (!UtilTexto.getInstance().contieneSoloAlfanumericoEspaciosEspeciales(contrasena)) {
            throw BusinessLogicBackEndException.reportar(
                    "La contraseña solo puede contener letras, numeros y espacios"
            );
        }
    }

    private void validarIntegridadPrefijo(String prefijoTelefono) throws BackEndException {
        //  1. Obligatoriedad: El prefijo debe ser obligatorio
        if(UtilTexto.getInstance().estaVacia(prefijoTelefono)) {
            throw BusinessLogicBackEndException.reportar("El prefijo es un dato obligatorio");
        }

        //  2. Longitud: Entre 2 y 5 caracteres
        var util = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(prefijoTelefono);
        if(util.length() > 5 || util.length() <2){
            throw BusinessLogicBackEndException.reportar("El prefijo debe tener entre 2 y 5 caracteres");
        }

        //  3. Formato: simbolo "+" y numeros
        if (!UtilTexto.getInstance().contieneSoloNumerosYMas(prefijoTelefono)) {
            throw BusinessLogicBackEndException.reportar(
                    "El prefijo solo puede contener numeros y el simbolo '+' "
            );
        }
    }

    private void validarIntegridadTelefono(String telefono) throws BackEndException {
        //  1. Obligatoriedad: El teléfono debe ser obligatorio
        if(UtilTexto.getInstance().estaVacia(telefono)) {
            throw BusinessLogicBackEndException.reportar("El numero de teléfono es un dato obligatorio");
        }

        //  2. Longitud: Entre 7 y 15 caracteres
        var util = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(telefono);
        if(util.length() > 15 || util.length() <7){
            throw BusinessLogicBackEndException.reportar("El número de teléfono debe tener entre 7 y 15 caracteres");
        }

        //  3. Formato: solo numeros
        if (!UtilTexto.getInstance().contieneSoloNumeros(telefono)) {
            throw BusinessLogicBackEndException.reportar(
                    "El número teléfonico solo puede contener digitos (0-9)"
            );
        }
    }

    private void validarNoExistaClienteCoMismoTelefono(String telefono) throws BackEndException {
        var filtro = new ClienteEntity();
        filtro.setTelefono(telefono);

        var listaResultados = factory.getClienteDAO().consultar(filtro);
        //Si la lista devolvió resultados entonces si existe una cancha con el mismo nombre
        if(!listaResultados.isEmpty()){
            throw BusinessLogicBackEndException.reportar("Ya existe un usuario con ese teléfono");
        }
    }

    private void validarNoExistaClienteConMismoUsername(String identificacion) throws BackEndException {
        var filtro = new ClienteEntity();
        filtro.setUsername(identificacion);

        var listaResultados = factory.getClienteDAO().consultar(filtro);
        if(!listaResultados.isEmpty()){
            throw BusinessLogicBackEndException.reportar("Ya existe ese nombre de usuario");
        }
    }

    private UUID generarIdentificadorNuevoCliente() throws BackEndException {
        UUID nuevoId;
        var existeId = false;
        do {
            nuevoId = UtilUUID.generarNuevoUUID();
            var cliente = factory.getClienteDAO().consultarPorId(nuevoId);
            existeId = !UtilUUID.esValorDefecto(cliente.getId());


        }while (existeId);
        return nuevoId;
    }


    @Override
    public void modificarClienteExistente(UUID clienteId, ClienteDomain datosActualizados) throws BackEndException {
        ClienteEntity clienteEntity = null;//ClienteEntityAssembler.getInstance.toEntity(clienteDomainACrear)
        factory.getClienteDAO().modificar(clienteId,clienteEntity);
    }

    @Override
    public void darBajaDefinitivamenteClienteExistente(UUID clienteId) throws BackEndException {
        ClienteEntity clienteEntity = null;
        factory.getClienteDAO().eliminar(clienteId);

    }

    @Override
    public ClienteDomain consultarClientePorId(UUID clienteId) throws BackEndException {
        ClienteEntity clienteEntity = null;
        factory.getClienteDAO().consultarPorId(clienteId);
        return null;
    }

    @Override
    public List<ClienteDomain> consultarClientes(ClienteDomain filtro) throws BackEndException {
        ClienteEntity clienteFilter = null;
        List<ClienteEntity> clienteEntities = factory.getClienteDAO().consultar(clienteFilter);
        List<ClienteDomain> datosAretornar= null;
        return datosAretornar;
    }

    @Override
    public UsuarioDomain iniciarSesion(String username, String rawPassword, String ipAddress, String userAgent) throws BackEndException {
            // 1. Validaciones como antes…
            if (UtilTexto.getInstance().estaVacia(username) || UtilTexto.getInstance().estaVacia(rawPassword)) {
                throw BusinessLogicBackEndException.reportar("Usuario y contraseña son obligatorios");
            }

            // 2. Buscar el cliente…
            var filtro = new ClienteEntity();
            filtro.setUsername(username.trim());
            var resultados = factory.getClienteDAO().consultar(filtro);
            if (resultados.isEmpty() || !resultados.get(0).getContrasena().equals(rawPassword)) {
                throw BusinessLogicBackEndException.reportar("Credenciales inválidas");
            }
            ClienteEntity e = resultados.get(0);

            // 4. Mapear y devolver
            return new ClienteDomain(
                    e.getId(),
                    e.getNombre(),
                    e.getUsername(),
                    e.getContrasena(),
                    e.getPrefijoTelefono(),
                    e.getTelefono()
            );
    }

    @Override
    public void cerrarSesion(UUID usuarioId) {

    }

    @Override
    public void recuperarContrasena(String username) {
        //TODO: Logica de recuperarConstraseña
    }

    @Override
    public void cambiarContrasena(UUID usuarioId, String rawPasswordActual, String rawPasswordNueva) {
        //TODO: Logica de cambiarConstraseña
    }

    @Override
    public UsuarioDomain consultarUsuarioPorId(UUID usuarioId) {
        return null;
    }

    @Override
    public List<UsuarioDomain> listarUsuarios(UsuarioDomain filtro) {
        return List.of();
    }


}
