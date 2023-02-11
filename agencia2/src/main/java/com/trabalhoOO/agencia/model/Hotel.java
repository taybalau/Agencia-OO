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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_hoteis")
public class Hotel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	private String nome;
	private int estrelas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AluguelHotel> alugueisHotel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}
	public List<AluguelHotel> getAlugueisHotel() {
		return alugueisHotel;
	}
	public void setAlugueisHotel(List<AluguelHotel> alugueisHotel) {
		this.alugueisHotel = alugueisHotel;
	}
}
