package com.kruger.challenger.springboot.empleados.models.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacunaciones")
public class Vacunacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha_vacunacion")
    private LocalDate fechaVacunacion;
    
    @Column(name = "numero_dosis")
    private Integer numeroDosis;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_vacuna")
    private TipoVacuna tipoVacuna;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_vacunacion")
    private EstadoVacunacion estadoVacunacion;

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