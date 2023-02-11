package com.trabalhoOO.agencia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuário {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String nome;
	private String email;
	private String senha;
	private String CEP;
	private String endereço;
	private String contato;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="usuário")
	@JsonIgnore
	private List<Passagem> passagens;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="usuário")
	@JsonIgnore
	private List<AluguelCarro> alugueisCarro;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="usuário")
	@JsonIgnore
	private List<AluguelHotel> alugueisHotel;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="usuário")
	@JsonIgnore
	private List<Pagamento> pagamentos;

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public List<Passagem> getPassagens() {
		return passagens;
	}
	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
	}
	public List<AluguelCarro> getAlugueisCarro() {
		return alugueisCarro;
	}
	public void setAlugueisCarro(List<AluguelCarro> alugueisCarro) {
		this.alugueisCarro = alugueisCarro;
	}
	public List<AluguelHotel> getAlugueisHotel() {
		return alugueisHotel;
	}
	public void setAlugueisHotel(List<AluguelHotel> alugueisHotel) {
		this.alugueisHotel = alugueisHotel;
	}
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}
	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	

}
