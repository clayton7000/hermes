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
import com.hermes.model.TipoGasto;
import com.hermes.repository.ReceitaRepository;
import com.hermes.repository.TipoGastoRepository;

@RestController
@RequestMapping(path="/tipoGasto")
public class TipoGastoController {
	@Autowired
	private TipoGastoRepository repository;
	
	@GetMapping
	public List<TipoGasto> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<TipoGasto>> buscar(@PathVariable int id) {
		Optional<TipoGasto> tipoGasto = repository.findById(id);

		if (tipoGasto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(tipoGasto);
	}

	@PostMapping
	public TipoGasto adicionar(@RequestBody TipoGasto tipoGasto) {
		return repository.save(tipoGasto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoGasto> alterar(@RequestBody TipoGasto tipoGasto, @PathVariable int id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		tipoGasto.setId(id);
		tipoGasto = repository.save(tipoGasto);
		return ResponseEntity.ok(tipoGasto);
	}

		  @DeleteMapping("/{id}")
		  public  @ResponseBody void remover(@PathVariable int id) {
			  repository.deleteById(id);
		  }
}
