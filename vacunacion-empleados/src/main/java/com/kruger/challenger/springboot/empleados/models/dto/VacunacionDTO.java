package com.kruger.challenger.springboot.empleados.models.dto;

import java.time.LocalDate;


import com.kruger.challenger.springboot.empleados.models.entity.EstadoVacunacion;
import com.kruger.challenger.springboot.empleados.models.entity.TipoVacuna;

public class VacunacionDTO {

	private Long id;
	
    private LocalDate fechaVacunacion;
    
    private Integer numeroDosis;
    
    private TipoVacuna tipoVacuna;
    
    private EstadoVacunacion estadoVacunacion;

	public VacunacionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VacunacionDTO(Long id, LocalDate fechaVacunacion, Integer numeroDosis, TipoVacuna tipoVacuna,
			EstadoVacunacion estadoVacunacion) {
		super();
		this.id = id;
		this.fechaVacunacion = fechaVacunacion;
		this.numeroDosis = numeroDosis;
		this.tipoVacuna = tipoVacuna;
		this.estadoVacunacion = estadoVacunacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(LocalDate fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public Integer getNumeroDosis() {
		return numeroDosis;
	}

	public void setNumeroDosis(Integer numeroDosis) {
		this.numeroDosis = numeroDosis;
	}

	public TipoVacuna getTipoVacuna() {
		return tipoVacuna;
	}

	public void setTipoVacuna(TipoVacuna tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}

	public EstadoVacunacion getEstadoVacunacion() {
		return estadoVacunacion;
	}

	public void setEstadoVacunacion(EstadoVacunacion estadoVacunacion) {
		this.estadoVacunacion = estadoVacunacion;
	}
    
    
}
