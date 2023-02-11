package com.trabalhoOO.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoOO.agencia.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
