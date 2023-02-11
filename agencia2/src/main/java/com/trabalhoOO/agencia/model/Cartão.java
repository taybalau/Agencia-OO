package com.trabalhoOO.agencia.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class Cartão extends Pagamento {
	
	private int número;
	private int CVV;
	private LocalDate validade;
	private String nomeNoCartao;
	private String CPFDono;
	private Boolean crédito;
	
	public int getNúmero() {
		return número;
	}
	public void setNúmero(int número) {
		this.número = número;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public LocalDate getValidade() {
		return validade;
	}
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	public String getNomeNoCartao() {
		return nomeNoCartao;
	}
	public void setNomeNoCartao(String nomeNoCartao) {
		this.nomeNoCartao = nomeNoCartao;
	}
	public String getCPFDono() {
		return CPFDono;
	}
	public void setCPFDono(String cPFDono) {
		CPFDono = cPFDono;
	}
	public Boolean getCrédito() {
		return crédito;
	}
	public void setCrédito(Boolean crédito) {
		this.crédito = crédito;
	}


}
