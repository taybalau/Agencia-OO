package com.trabalhoOO.agencia.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_pjurídica", schema="agencia_oo")
public class PessoaJurídica extends Usuário{
	
	private String CNPJ;	
	
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
}
