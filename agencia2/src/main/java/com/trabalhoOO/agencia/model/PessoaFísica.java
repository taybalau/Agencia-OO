package com.trabalhoOO.agencia.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_pfísica", schema="agencia_oo")
public class PessoaFísica extends Usuário {
	
	private String CPF;
	private LocalDate nascimento;
	private String RG;
	private LocalDate dataRG;
	private String órgaoRG;
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public LocalDate getDataRG() {
		return dataRG;
	}
	public void setDataRG(LocalDate dataRG) {
		this.dataRG = dataRG;
	}
	public String getÓrgaoRG() {
		return órgaoRG;
	}
	public void setÓrgaoRG(String órgaoRG) {
		this.órgaoRG = órgaoRG;
	}

}
