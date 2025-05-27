package co.edu.uco.backend.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/paises")
public class ClienteController {

    @GetMapping
    public String consultar(){
        return "Consulta todos los clientes";
    }

    @PostMapping
    public String crear(){
        return "Crea un nuevo cliente";
    }

    @PutMapping
    public String modificar(){
        return "Modifica un cliente existente";
    }

    @DeleteMapping
    public String eliminar(){
        return "Elimina de forma definitiva un cliente";
    }
}
