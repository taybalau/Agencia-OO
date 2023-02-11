package com.trabalhoOO.agencia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.trabalhoOO.agencia.ENUM.TipoPassageiro;

@Entity
@Table(name="tb_passageiros")
public class Passageiro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String nome;
	private String passaporte;
	
	@Column(name="tipo_passageiro",columnDefinition = "ENUM('ADULTO', 'CRIANÇA')")
    @Enumerated(EnumType.STRING)
	private TipoPassageiro tipo;
	
	private String CPF;
	private LocalDate nascimento;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_passagem")
	private Passagem passagem;
	
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
	public String getPassaporte() {
		return passaporte;
	}
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
	public TipoPassageiro getTipo() {
		return tipo;
	}
	public void setTipo(TipoPassageiro tipo) {
		this.tipo = tipo;
	}
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
	public Passagem getPassagem() {
		return passagem;
	}
	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}
	
}
