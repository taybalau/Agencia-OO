package com.trabalhoOO.agencia.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_passagem")
public class Passagem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuário")
	private Usuário usuário;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_voo")
	private Voo voo;
	
	private int acento;
	private double preço;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "passagem", fetch = FetchType.LAZY)
	@JsonIgnore
	private Passageiro passageiro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuário getUsuário() {
		return usuário;
	}
	public void setUsuário(Usuário usuário) {
		this.usuário = usuário;
	}
	public Voo getVoo() {
		return voo;
	}
	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	public int getAcento() {
		return acento;
	}
	public void setAcento(int acento) {
		this.acento = acento;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double d) {
		this.preço = d;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	
	
}
