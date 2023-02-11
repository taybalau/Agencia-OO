package com.trabalhoOO.agencia.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoOO.agencia.model.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long>{
	
	Voo findVooBySaida(LocalDate data);
	
	Voo findVooByChegada(LocalDate data);

}
