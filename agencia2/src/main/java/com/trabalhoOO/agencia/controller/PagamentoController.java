package com.trabalhoOO.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoOO.agencia.model.Boleto;
import com.trabalhoOO.agencia.model.Cartão;
import com.trabalhoOO.agencia.model.Pagamento;
import com.trabalhoOO.agencia.service.BoletoService;
import com.trabalhoOO.agencia.service.CartãoService;
import com.trabalhoOO.agencia.service.PagamentoService;

@RequestMapping(value = "/api/user")
@RestController
public class PagamentoController {

	@Autowired
	private CartãoService cartãoService;

	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoService pagamentoService;

	@PostMapping(value = "/{idPassagem}/{idAluguelCarro}/{idAluguelHotel}/pagamento/boleto")
	public ResponseEntity<Boleto> pagamentoBoleto(@PathVariable Long idPassagem, @PathVariable Long idAluguelCarro, @PathVariable Long idAluguelHotel) {

		return new ResponseEntity<>(boletoService.gerarPagamentoBoleto(idPassagem, idAluguelCarro, idAluguelHotel), HttpStatus.OK);
	}

	@PostMapping(value = "/{idPassagem}/{idAluguelCarro}/{idAluguelHotel}/pagamento/cartão")
	public ResponseEntity<Cartão> pagamentoCartão(@RequestBody Cartão cartão, @PathVariable Long idPassagem, @PathVariable Long idAluguelCarro, 
			@PathVariable Long idAluguelHotel, @RequestParam(required = false) Integer parcelas) {

		return new ResponseEntity<>(cartãoService.gerarPagamentoCartão(idPassagem, idAluguelCarro, idAluguelHotel,
				cartão, parcelas), HttpStatus.OK);
	}
	
	@PostMapping(value = "/{idPagamento}/finalizarPagamento")
	public ResponseEntity<Pagamento> finalizarPagamento(@RequestBody Pagamento pagamento, @PathVariable Long idPagamento) {

		return new ResponseEntity<>(pagamentoService.compraFinalizada(pagamento, idPagamento), HttpStatus.OK);
	}

}
