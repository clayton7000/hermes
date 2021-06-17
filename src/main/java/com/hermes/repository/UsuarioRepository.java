package com.hermes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hermes.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
