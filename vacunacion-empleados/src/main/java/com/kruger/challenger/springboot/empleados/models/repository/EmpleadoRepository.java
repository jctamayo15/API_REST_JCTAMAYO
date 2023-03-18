package com.kruger.challenger.springboot.empleados.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kruger.challenger.springboot.empleados.models.entity.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
	
	// Método para buscar empleados por cédula
	@Query("SELECT u FROM Empleado u WHERE u.cedula = ?1")
    Empleado findByCedula(String cedula);
    
    // Método para buscar empleados por estado de vacunación
	@Query("SELECT u FROM Empleado u JOIN u.vacunacion v WHERE v.estadoVacunacion = :estadoVacunacion")
    List<Empleado> findByEstadoVacunacion(@Param("estadoVacunacion") String estadoVacunacion);
    
    // Método para buscar empleados por tipo de vacuna
	@Query("SELECT u FROM Empleado u JOIN u.vacunacion v WHERE v.tipoVacuna = :tipoVacuna")
	List<Empleado> findByTipoVacuna(@Param("tipoVacuna") String tipoVacuna);
    
    // Método para buscar empleados por rango de fecha de vacunación
	@Query("SELECT u FROM Empleado u JOIN u.vacunacion v WHERE v.fechaVacunacion BETWEEN :desde AND :hasta")
	List<Empleado> findByFechaVacunacionBetween(@Param("desde") Object object, @Param("hasta") Object object2);
    //(LocalDate fechaInicio, LocalDate fechaFin);

 
	
}
