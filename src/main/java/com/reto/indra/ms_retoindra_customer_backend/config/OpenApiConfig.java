package com.reto.indra.ms_retoindra_customer_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tu API Documentada con OpenAPI 3.0")
                        .version("1.0")
                        .description("Esta es la documentación de tu API")
                        .contact(new Contact()
                                .name("Tu Nombre")
                                .email("tuemail@ejemplo.com")));
    }
}