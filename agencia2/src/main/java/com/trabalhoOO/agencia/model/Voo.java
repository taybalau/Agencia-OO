package com.trabalhoOO.agencia.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_voos")
public class Voo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	private LocalDate saida;
	private LocalDate chegada;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_origem")
	private Aeroporto origem;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_destino")
	private Aeroporto destino;
	
	@Column(name="empresaÁerea")
	private String empresa;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "voo", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Passagem> passagens;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getSaida() {
		return saida;
	}
	public void setSaida(LocalDate saida) {
		this.saida = saida;
	}
	public LocalDate getChegada() {
		return chegada;
	}
	public void setChegada(LocalDate chegada) {
		this.chegada = chegada;
	}
	public Aeroporto getOrigem() {
		return origem;
	}
	public void setOrigem(Aeroporto origem) {
		this.origem = origem;
	}
	public Aeroporto getDestino() {
		return destino;
	}
	public void setDestino(Aeroporto destino) {
		this.destino = destino;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public List<Passagem> getPassagens() {
		return passagens;
	}
	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
	}

}
