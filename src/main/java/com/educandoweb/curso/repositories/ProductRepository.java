package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Product;

//JpaRepository<TipoDaEntidade, TipoDoId>
public interface ProductRepository extends JpaRepository<Product, Long> {

}
