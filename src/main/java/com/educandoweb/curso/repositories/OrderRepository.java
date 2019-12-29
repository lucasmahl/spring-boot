package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Order;

//JpaRepository<TipoDaEntidade, TipoDoId>
public interface OrderRepository extends JpaRepository<Order, Long> {

}
