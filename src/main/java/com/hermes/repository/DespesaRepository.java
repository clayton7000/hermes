package com.hermes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hermes.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

}
