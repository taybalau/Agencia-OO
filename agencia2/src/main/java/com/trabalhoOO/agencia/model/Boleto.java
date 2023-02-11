package com.trabalhoOO.agencia.model;

import java.time.LocalDate;

public class Boleto extends Pagamento {
	
	private Long codigo;
	private LocalDate validade;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public LocalDate getValidade() {
		return validade;
	}
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
}
