package com.trabalhoOO.agencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pagamentos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	private double Valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuário")
	private Usuário usuário;
	
	@Column(name="compra_finalizada")
	private boolean compraFinalizada;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public Usuário getUsuário() {
		return usuário;
	}
	public void setUsuário(Usuário usuário) {
		this.usuário = usuário;
	}
	public boolean isCompraFinalizada() {
		return compraFinalizada;
	}
	public void setCompraFinalizada(boolean compraFinalizada) {
		this.compraFinalizada = compraFinalizada;
	}
	
}
