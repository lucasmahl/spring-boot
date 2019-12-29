package com.educandoweb.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.services.UserService;

//@RestController é um recurso web implementada por um controlador rest
//este arquivo é o controlador rest q responde no caminho /users

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// dependencia para o service
	@Autowired
	private UserService service;

	// endpoint pra acessar usuários
	// ResponseEntity pra retornar respostas de requisições web
	@GetMapping // getmapping pra indicar q responde a requisição get do http
	public ResponseEntity<List<User>> findAll() {
		List<User> lista = service.findAll();

		// ok pra retornar a resposta com sucesso no http
		// body pra retornar o corpo da resosta
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	// post pq irá inserir
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		// @RequestBody pra dizer q irá chegar no modo json na hora de fazer requisição
		// e esse json será deserializado pro objeto User
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);// pra auxiliar na resposta

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){// PathVariablepro Long id ser reconhecido como variavel da url
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){// PathVariablepro Long id ser reconhecido como variavel da url
		obj = service.update(id, obj);//atualizou usuário
		return ResponseEntity.ok().body(obj);
		
	}
	
}
