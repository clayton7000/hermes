package com.hermes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hermes.model.Receita;
import com.hermes.model.Usuario;
import com.hermes.repository.ReceitaRepository;
import com.hermes.repository.UsuarioRepository;

@RestController
@RequestMapping(path="/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public List<Usuario> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> buscar(@PathVariable int id) {
		Optional<Usuario> usuario = repository.findById(id);

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		usuario.setId(id);
		usuario = repository.save(usuario);
		return ResponseEntity.ok(usuario);
	}

		  @DeleteMapping("/{id}")
		  public  @ResponseBody void remover(@PathVariable int id) {
			  repository.deleteById(id);
		  }
}
