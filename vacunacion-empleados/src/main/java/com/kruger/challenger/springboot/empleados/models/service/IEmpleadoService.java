package com.kruger.challenger.springboot.empleados.models.service;

import java.time.LocalDate;
import java.util.List;

import com.kruger.challenger.springboot.empleados.models.dto.EmpleadoDTO;
import com.kruger.challenger.springboot.empleados.models.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> findAll();

	public Empleado guardarEmpleado(EmpleadoDTO empleado);

	public Empleado editarEmpleado(Long id, EmpleadoDTO empleado);
	
	public void eliminarEmpleado(Long id);
	
	// Método para buscar empleados por cédula
    Empleado findByCedula(String cedula);
    
    // Método para buscar empleados por estado de vacunación
    List<Empleado> findByEstadoVacunacion(String estadoVacunacion);
    
    // Método para buscar empleados por tipo de vacuna
    List<Empleado> findByTipoVacuna(String tipoVacuna);
    
    // Método para buscar empleados por rango de fecha de vacunación
    List<Empleado> findByFechaVacunacionBetween(LocalDate fechaInicio, LocalDate fechaFin);
 
    public List<Empleado> searchEmployees(String tipoVacuna, LocalDate startDate, LocalDate endDate, String isVaccinated);

}
