package com.trabalhoOO.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoOO.agencia.model.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long>{
	
	Passagem findPassagemByAcento(int acento);

}
