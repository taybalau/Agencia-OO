package com.trabalhoOO.agencia.repository;

import org.springframework.transaction.annotation.Transactional;

import com.trabalhoOO.agencia.model.PessoaFísica;

@Transactional
public interface PessoaFísicaRepository extends UsuárioRepository<PessoaFísica>{

}
