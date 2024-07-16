package com.matawan.testvasco.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("Vasco MATAWAN Spring Boot Test")
                .version("v1")
                .description("API description")
                .license(new License().name("Vasco Licence 2.0")));
    }
}
