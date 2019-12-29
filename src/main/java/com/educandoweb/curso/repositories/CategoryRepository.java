package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Category;

//JpaRepository<TipoDaEntidade, TipoDoId>
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
