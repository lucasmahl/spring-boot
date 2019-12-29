package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.services.OrderService;

//@RestController é um recurso web implementada por um controlador rest
//este arquivo é o controlador rest q responde no caminho /orders

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	// dependencia para o service
	@Autowired
	private OrderService service;

	// endpoint pra acessar ordens
	// ResponseEntity pra retornar respostas de requisições web
	@GetMapping // getmapping pra indicar q responde a requisição get do http
	public ResponseEntity<List<Order>> findAll() {
		List<Order> lista = service.findAll();

		// ok pra retornar a resposta com sucesso no http
		// body pra retornar o corpo da resosta
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
