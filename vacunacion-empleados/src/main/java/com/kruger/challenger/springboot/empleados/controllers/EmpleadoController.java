package com.kruger.challenger.springboot.empleados.controllers;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.challenger.springboot.empleados.models.dto.EmpleadoDTO;
import com.kruger.challenger.springboot.empleados.models.entity.Empleado;
import com.kruger.challenger.springboot.empleados.models.service.IEmpleadoService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoservice;
	
	// ===============
	// ===== GET =====
	// ===============
	@Operation(summary = "Consulta de todos los empleados")
	@GetMapping("/empleados")
    public List<Empleado> getAllEmpleados() {
        return empleadoservice.findAll();
    }
	
	
	// ===============
	// ===== GET =====
	// ===============
	@Operation(summary = "Obtener empleado por cedula")
	@GetMapping("/empleados/{cedula}")
    public Empleado getEmpleadosByCedula(@PathVariable String cedula) {
        return empleadoservice.findByCedula(cedula);
    }
	
	
	
	// ===============
	// ===== POST =====
	// ===============
	@Operation(summary = "crear un empleado, se genera un usuario y password")
	@PostMapping("/empleados")
    public Empleado crearEmpleado(@RequestBody EmpleadoDTO empleado) {
        return empleadoservice.guardarEmpleado(empleado);
    }
	
	
	// ===============
	// ===== PUT =====
	// ===============
	@Operation(summary = "Actualizar los datos del empleado")
	@PutMapping("/empleados/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleado) {
        return empleadoservice.editarEmpleado(id, empleado);
    }
	
	
	// ===============
	// ====DELETE=====
	// ===============
	@Operation(summary = "Eliminar el empleado por id")
	@DeleteMapping("/employees/{id}")
    public Map<String, Boolean> eliminarEmpleado(@PathVariable Long id) {
        empleadoservice.eliminarEmpleado(id);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	// ===============
	// ===== GET =====
	// ===============
	@Operation(summary = "devuelve la lista de empleado, filtro por estado de vacunacion, filtro por tipo de vacuna, filtro por rando de fecha de vacunacion")
	@GetMapping("/employees/search")
	public List<Empleado> searchEmployees(@RequestParam(value = "estadoVacunacion", required = false) String estadoVacunacion,
                                          @RequestParam(value = "tipoVacuna", required = false) String tipoVacuna,
                                          @RequestParam(value = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
                                          @RequestParam(value = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
	
	  return empleadoservice.searchEmployees(tipoVacuna, fechaInicio, fechaFin, estadoVacunacion);
	}

}
