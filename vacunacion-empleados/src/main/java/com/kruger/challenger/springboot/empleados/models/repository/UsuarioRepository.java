package com.kruger.challenger.springboot.empleados.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.kruger.challenger.springboot.empleados.models.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
