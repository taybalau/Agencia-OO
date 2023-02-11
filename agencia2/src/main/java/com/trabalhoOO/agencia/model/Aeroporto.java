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
@Table(name="tb_aeroportos")
public class Aeroporto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String nome;
	private String país;
	private String estado;
	private String cidade;
	private Boolean internacional;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "origem", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Voo> vooOrigem;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "destino", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Voo> vooDestino;

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

	public String getPaís() {
		return país;
	}

	public void setPaís(String país) {
		this.país = país;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Boolean getInternacional() {
		return internacional;
	}

	public void setInternacional(Boolean internacional) {
		this.internacional = internacional;
	}

	public List<Voo> getVooOrigem() {
		return vooOrigem;
	}

	public void setVooOrigem(List<Voo> vooOrigem) {
		this.vooOrigem = vooOrigem;
	}

	public List<Voo> getVooDestino() {
		return vooDestino;
	}

	public void setVooDestino(List<Voo> vooDestino) {
		this.vooDestino = vooDestino;
	}
	

}
