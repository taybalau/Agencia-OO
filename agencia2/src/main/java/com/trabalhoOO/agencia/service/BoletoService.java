package com.trabalhoOO.agencia.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoOO.agencia.model.Boleto;
import com.trabalhoOO.agencia.model.Pagamento;

@Service
public class BoletoService {

	@Autowired
	private PagamentoService pagamentoService;


	public Boleto gerarBoleto(double valorCompra) {
		Boleto boleto = new Boleto();
		boleto.setValor(valorCompra);
		boleto.setValidade(gerarDataVencimento());
		boleto.setCodigo(gerarNumeroAleatorio());
		return boleto;
	}

	private LocalDate gerarDataVencimento() {
		LocalDate dataAtual = LocalDate.now();
		return dataAtual.plusDays(30);
	}

	private long gerarNumeroAleatorio() {
		int dígitos = 12;
		return (long) (Math.random() * (Math.pow(10, dígitos) - Math.pow(10, dígitos - 1)))
				+ (long) Math.pow(10, dígitos - 1);
	}

	public Boleto gerarPagamentoBoleto(Long idPassagem, Long idAluguelCarro, Long idAluguelHotel) {

		Pagamento pagamento = pagamentoService.gerarPagamento(idPassagem, idAluguelCarro, idAluguelHotel);

		Boleto boleto = gerarBoleto(pagamento.getValor());
		
		boleto.setId(pagamento.getId());
		boleto.setUsuário(pagamento.getUsuário());

		return boleto;
	}
}
