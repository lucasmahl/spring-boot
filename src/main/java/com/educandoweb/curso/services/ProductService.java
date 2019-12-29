package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.repositories.ProductRepository;

@Service // para ela ser usada como componente, e ser injetado automaticamente com
			// autowired
public class ProductService {

	@Autowired // pra fazer injeção de dependencia
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long Id) {
		Optional<Product> obj = repository.findById(Id);

		return obj.get();
	}

}
