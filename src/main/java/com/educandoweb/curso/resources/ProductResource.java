package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.services.ProductService;

//@RestController é um recurso web implementada por um controlador rest
//este arquivo é o controlador rest q responde no caminho /products

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	// dependencia para o service
	@Autowired
	private ProductService service;

	// endpoint pra acessar usuários
	// ResponseEntity pra retornar respostas de requisições web
	@GetMapping // getmapping pra indicar q responde a requisição get do http
	public ResponseEntity<List<Product>> findAll() {
		List<Product> lista = service.findAll();

		// ok pra retornar a resposta com sucesso no http
		// body pra retornar o corpo da resosta
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
