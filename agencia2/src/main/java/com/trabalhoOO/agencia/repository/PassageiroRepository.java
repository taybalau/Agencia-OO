package com.trabalhoOO.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoOO.agencia.model.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
	
	Passageiro findPassageiroByCPF(String CPF);

}
