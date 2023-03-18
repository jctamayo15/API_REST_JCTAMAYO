package com.kruger.challenger.springboot.empleados.models.dto;


public class EmpleadoDTO {
	
	private Long id;
	 
	private String cedula;
	    
    private String nombres;
    
    private String apellidos;
    
    private String correo;
    
    private String fechaNacimiento;
    
    private String direccion;
    
    private String telefono;
    
    private String usuario;
    
    private String password;
    
    private VacunacionDTO vacunacion;
    

	public EmpleadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmpleadoDTO(Long id, String cedula, String nombres, String apellidos, String correo, String fechaNacimiento,
			String direccion, String telefono, String usuario, String password, VacunacionDTO vacunacion) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.usuario = usuario;
		this.password = password;
		this.vacunacion = vacunacion;
	}



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

	public VacunacionDTO getVacunacion() {
		return vacunacion;
	}

	public void setVacunacion(VacunacionDTO vacunacion) {
		this.vacunacion = vacunacion;
	}


    
    

}
