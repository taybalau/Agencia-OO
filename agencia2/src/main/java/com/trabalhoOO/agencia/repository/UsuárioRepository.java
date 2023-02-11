package com.trabalhoOO.agencia.repository;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoOO.agencia.model.Usuário;

@Repository
@Primary
public interface UsuárioRepository <T extends Usuário> extends JpaRepository<T, Long>{

	Optional<T> findByEmail(String email);
}
