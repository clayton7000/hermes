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
import com.hermes.model.Planejamento;
import com.hermes.repository.DespesaRepository;
import com.hermes.repository.PlanejamentoRepository;

@RestController
@RequestMapping(path="/planejamento")
public class PlanejamentoController {
	@Autowired
	private PlanejamentoRepository repository;
	
	@GetMapping
	public List<Planejamento> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Planejamento>> buscar(@PathVariable int id) {
		Optional<Planejamento> planejamento = repository.findById(id);

		if (planejamento == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(planejamento);
	}

	@PostMapping
	public Planejamento adicionar(@RequestBody Planejamento planejamento) {
		return repository.save(planejamento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Planejamento> alterar(@RequestBody Planejamento planejamento, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		planejamento.setId(id);
		planejamento = repository.save(planejamento);
		return ResponseEntity.ok(planejamento);
	}

		  @DeleteMapping("/{id}")
		  public  @ResponseBody void remover(@PathVariable int id) {
			  repository.deleteById(id);
		  }
}
