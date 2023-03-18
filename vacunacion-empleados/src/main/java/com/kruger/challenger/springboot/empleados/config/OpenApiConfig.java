package com.kruger.challenger.springboot.empleados.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI(@Value("3.0") String appVersion) {
	    return new OpenAPI()
	      .info(new Info()
	      .title("ApiRest Empleados Vacunacion SpringBoot")
	      .version(appVersion)
	      .description("* Api Restful para la Aplicación Web de Vacunacion de Empleados (https://https://github.com/jctamayo15/API_REST_JCTAMAYO)\r\n"
	      		+ "* La Misma consta de todas las Operaciones CRUD, documentación completa de la Api con open-api para la visualización con swagger \r\n")
	      .termsOfService("http://swagger.io/terms/"));

	}

}
