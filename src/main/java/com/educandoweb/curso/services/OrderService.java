package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.repositories.OrderRepository;

@Service // para ela ser usada como componente, e ser injetado automaticamente com
			// autowired
public class OrderService {

	@Autowired // pra fazer injeção de dependencia
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long Id) {
		Optional<Order> obj = repository.findById(Id);

		return obj.get();
	}

}
