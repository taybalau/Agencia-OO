package com.trabalhoOO.agencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.trabalhoOO.agencia.model.Cartão;
import com.trabalhoOO.agencia.model.Pagamento;

@Service
public class CartãoService {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	public double parcelarCompra(double valorCompra, int parcelas) {

	    if (parcelas < 1 || parcelas > 12) {
	     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insira uma parcela de 1 até 12");
	    }

	    double valorParcela = valorCompra / parcelas;

	    return valorParcela;
	  }
	
	public Cartão gerarPagamentoCartão(Long idPassagem, Long idAluguelCarro, Long idAluguelHotel,
			Cartão cartão, Integer parcelas) {

		Pagamento pagamento = pagamentoService.gerarPagamento(idPassagem, idAluguelCarro, idAluguelHotel);
		
		cartão.setId(pagamento.getId());
		cartão.setUsuário(pagamento.getUsuário());
		cartão.setValor(pagamento.getValor());

		if (cartão.getCrédito() == true) {
			parcelarCompra(cartão.getValor(), parcelas);
		}

		return cartão;
	}
	

	public Cartão gerarPagamentoCartão(Long idPassagem, Long idAluguelCarro, Long idAluguelHotel,
			Cartão cartão) {

		Pagamento pagamento = pagamentoService.gerarPagamento(idPassagem, idAluguelCarro, idAluguelHotel);
		
		cartão.setId(pagamento.getId());
		cartão.setUsuário(pagamento.getUsuário());
		cartão.setValor(pagamento.getValor());

		return cartão;
	}
}
 