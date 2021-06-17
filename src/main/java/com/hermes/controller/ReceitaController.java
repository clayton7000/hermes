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

import com.hermes.model.Planejamento;
import com.hermes.model.Receita;
import com.hermes.repository.PlanejamentoRepository;
import com.hermes.repository.ReceitaRepository;

@RestController
@RequestMapping(path="/receita")
public class ReceitaController {
	@Autowired
	private ReceitaRepository repository;
	
	@GetMapping
	public List<Receita> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Receita>> buscar(@PathVariable int id) {
		Optional<Receita> receita = repository.findById(id);

		if (receita == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(receita);
	}

	@PostMapping
	public Receita adicionar(@RequestBody Receita receita) {
		return repository.save(receita);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Receita> alterar(@RequestBody Receita receita, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		receita.setId(id);
		receita = repository.save(receita);
		return ResponseEntity.ok(receita);
	}

		  @DeleteMapping("/{id}")
		  public  @ResponseBody void remover(@PathVariable int id) {
			  repository.deleteById(id);
		  }
}
