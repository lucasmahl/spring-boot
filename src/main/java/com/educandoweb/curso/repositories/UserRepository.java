package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.User;

//JpaRepository<TipoDaEntidade, TipoDoId>
public interface UserRepository extends JpaRepository<User, Long>{
	
	
	
	
}
