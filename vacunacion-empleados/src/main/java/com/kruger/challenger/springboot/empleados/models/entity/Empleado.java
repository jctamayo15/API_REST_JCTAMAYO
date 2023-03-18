package com.kruger.challenger.springboot.empleados.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 5865407666208420884L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cedula", unique = true, nullable = false)
    private String cedula;
    
    @Column(name = "nombres", nullable = false)
    private String nombres;
    
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    
    @Column(name = "correo", unique = true, nullable = false)
    private String correo;
    
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "usuario", unique = true, nullable = false)
    private String usuario;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    /*@OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL)
    @JoinColumn(name = "vacunacion_id", referencedColumnName = "id")
    private Vacunacion vacunacion;*/
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vacunacion_id", referencedColumnName = "id")
    private Vacunacion vacunacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Vacunacion getVacunacion() {
		return vacunacion;
	}

	public void setVacunacion(Vacunacion vacunacion) {
		this.vacunacion = vacunacion;
	}
	
	
	
    
    //@OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL)
    //private EstadoVacunacion estadoVacunacion;
    
    

}
