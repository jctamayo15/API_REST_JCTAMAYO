package com.kruger.challenger.springboot.empleados;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VacunacionEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacunacionEmpleadosApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
