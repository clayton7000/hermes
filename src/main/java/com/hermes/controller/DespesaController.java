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

import com.hermes.model.Despesa;
import com.hermes.repository.DespesaRepository;

@RestController
@RequestMapping(path="/despesa")
public class DespesaController {
	@Autowired
	private DespesaRepository repository;
	
	@GetMapping
	public List<Despesa> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Despesa>> buscar(@PathVariable int id) {
		Optional<Despesa> despesa = repository.findById(id);

		if (despesa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(despesa);
	}

	@PostMapping
	public Despesa adicionar(@RequestBody Despesa despesa) {
		return repository.save(despesa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Despesa> alterar(@RequestBody Despesa despesa, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		despesa.setId(id);
		despesa = repository.save(despesa);
		return ResponseEntity.ok(despesa);
	}

		  @DeleteMapping("/{id}")
		  public  @ResponseBody void remover(@PathVariable int id) {
			  repository.deleteById(id);
		  }

}
