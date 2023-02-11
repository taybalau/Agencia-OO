package com.trabalhoOO.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoOO.agencia.model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	
	
}
