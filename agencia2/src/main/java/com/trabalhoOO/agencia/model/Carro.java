package com.trabalhoOO.agencia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_carros")
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String placa;
	
	private String modelo;
	private int ano;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "carro", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AluguelCarro> alugueisCarros;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public List<AluguelCarro> getAlugueisCarros() {
		return alugueisCarros;
	}
	public void setAlugueisCarros(List<AluguelCarro> alugueisCarros) {
		this.alugueisCarros = alugueisCarros;
	}
	
	
}
