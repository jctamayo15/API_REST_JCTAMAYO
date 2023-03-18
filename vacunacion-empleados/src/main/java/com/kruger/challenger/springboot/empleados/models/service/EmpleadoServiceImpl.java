package com.kruger.challenger.springboot.empleados.models.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kruger.challenger.springboot.empleados.models.dto.EmpleadoDTO;
import com.kruger.challenger.springboot.empleados.models.dto.VacunacionDTO;
import com.kruger.challenger.springboot.empleados.models.entity.Empleado;
import com.kruger.challenger.springboot.empleados.models.entity.EstadoVacunacion;
import com.kruger.challenger.springboot.empleados.models.entity.Usuario;
import com.kruger.challenger.springboot.empleados.models.entity.Vacunacion;
import com.kruger.challenger.springboot.empleados.models.entity.Rol;
import com.kruger.challenger.springboot.empleados.models.repository.EmpleadoRepository;
import com.kruger.challenger.springboot.empleados.models.repository.UsuarioRepository;
import com.kruger.challenger.springboot.empleados.models.repository.VacunacionRepository;
import com.kruger.challenger.springboot.empleados.utils.*;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VacunacionRepository  VacunacionRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public Empleado guardarEmpleado(EmpleadoDTO empleadoDTO ) {
		Utils util = new Utils();
        String password = util.generateRandomPassword(); // Genera una contraseña aleatoria
        empleadoDTO.setUsuario(empleadoDTO.getCedula());
        empleadoDTO.setPassword(password);// Asigna la contraseña generada al empleado
        createUser(empleadoDTO); 
        
        //ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        
        Empleado empleado = modelMapper.map(empleadoDTO, Empleado.class);
        VacunacionRepository.save(empleado.getVacunacion());
        return empleadoRepository.save(empleado);
    }
	
	@Override
	public Empleado editarEmpleado(Long id, EmpleadoDTO empleado) {
        Empleado empleadoActual = empleadoRepository.findById(id).orElseThrow();
        if(empleado.getFechaNacimiento()!=null)
        empleadoActual.setFechaNacimiento(empleado.getFechaNacimiento());
        if(empleado.getDireccion()!=null)
        empleadoActual.setDireccion(empleado.getDireccion());
        if(empleado.getTelefono()!=null)
        empleadoActual.setTelefono(empleado.getTelefono());
        VacunacionDTO vacunacionDTO = empleado.getVacunacion();
        if(vacunacionDTO.getEstadoVacunacion()==EstadoVacunacion.VACUNADO) {
        	//ModelMapper modelMapper = new ModelMapper();
        	modelMapper.getConfiguration().setSkipNullEnabled(true);
        	Vacunacion vacunacion = modelMapper.map(vacunacionDTO, Vacunacion.class);
        	empleadoActual.setVacunacion(vacunacion);
        }
       
        return empleadoRepository.save(empleadoActual);
    }
	
	private void createUser(EmpleadoDTO empleado) {
		Usuario user= new Usuario();
	
		user.setContrasena(empleado.getPassword());
		user.setNombreUsuario(empleado.getUsuario());
		user.setRol(Rol.EMPLEADO);
		usuarioRepository.save(user);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findByCedula(String cedula) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByCedula(cedula);
	}

	
	@Override
	@Transactional(readOnly = true) 
	public List<Empleado> findByEstadoVacunacion(String estadoVacunacion) { 
		 return empleadoRepository.findByEstadoVacunacion(estadoVacunacion); 
	}
	  
	@Override
	@Transactional(readOnly = true) 
	public List<Empleado> findByTipoVacuna(String tipoVacuna) { // TODO Auto-generated method stub return
	     return empleadoRepository.findByTipoVacuna(tipoVacuna); 
	}
	 
	
	
	@Override
	@Transactional(readOnly = true) 
	public List<Empleado> findByFechaVacunacionBetween(LocalDate fechaInicio, LocalDate fechaFin) { //
	  //TODO Auto-generated method stub return
		 return empleadoRepository.findByFechaVacunacionBetween(fechaInicio, fechaFin); 
	}
	 
	
	

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		
		return (List<Empleado>) empleadoRepository.findAll();
	}

	@Override
	public void eliminarEmpleado(Long id) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(id);
	}
	
	@Override
	public List<Empleado> searchEmployees(String tipoVacuna, LocalDate startDate, LocalDate endDate, String estadoVacunacion) {
	   
		 List<Empleado> empleados = null;
	    if (tipoVacuna != null) {
	        empleados = empleadoRepository.findByTipoVacuna(tipoVacuna);
	    }
	    
	    if (startDate != null && endDate != null) {
	    	empleados =  empleadoRepository.findByFechaVacunacionBetween(startDate, endDate);
	    }
	    
	    if (estadoVacunacion != null) {
	    	empleados = empleadoRepository.findByEstadoVacunacion(estadoVacunacion);
	    }
	    
	    return empleados;
	}

}
