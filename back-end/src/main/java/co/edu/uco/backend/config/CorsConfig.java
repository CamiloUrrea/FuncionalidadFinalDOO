package co.edu.uco.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        // 1) Aplica CORS solo a las rutas que empiecen con /api/v1/
                        .addMapping("/api/v1/**")
                        // 2) Usamos allowedOriginPatterns("*") en lugar de allowedOrigins(...)
                        .allowedOriginPatterns("*")
                        // 3) Métodos HTTP permitidos
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // 4) Permitir todas las cabeceras
                        .allowedHeaders("*")
                        // 5) Dejar allowCredentials(true) para que el navegador pueda enviar cookies/Authorization
                        .allowCredentials(true);
            }
        };
    }
}

