package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.repositories.CategoryRepository;

@Service // para ela ser usada como componente, e ser injetado automaticamente com
			// autowired
public class CategoryService {

	@Autowired // pra fazer injeção de dependencia
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long Id) {
		Optional<Category> obj = repository.findById(Id);

		return obj.get();
	}

}
