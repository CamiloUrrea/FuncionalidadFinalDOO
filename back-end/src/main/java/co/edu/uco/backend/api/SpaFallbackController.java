package co.edu.uco.backend.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaFallbackController {

    @RequestMapping({
            "/{path:[^\\.]*}",
            "/**/{path:[^\\.]*}"
    })
    public String forwardToIndex(@PathVariable("path") String path) {
        // `path` no se usa en la lógica, solo para que Spring/Sonar no protesten
        return "forward:/index.html";
    }
}

