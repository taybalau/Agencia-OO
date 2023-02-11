package com.trabalhoOO.agencia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.trabalhoOO.agencia.model.AluguelCarro;
import com.trabalhoOO.agencia.model.AluguelHotel;
import com.trabalhoOO.agencia.model.Pagamento;
import com.trabalhoOO.agencia.model.Passagem;
import com.trabalhoOO.agencia.model.Usuário;
import com.trabalhoOO.agencia.repository.AluguelCarroRepository;
import com.trabalhoOO.agencia.repository.AluguelHotelRepository;
import com.trabalhoOO.agencia.repository.PagamentoRepository;
import com.trabalhoOO.agencia.repository.PassagemRepository;
import com.trabalhoOO.agencia.repository.UsuárioRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private UsuárioRepository usuárioRepository;

	@Autowired
	private PassagemRepository passagemRepository;

	@Autowired
	private AluguelHotelRepository aluguelHotelRepository;

	@Autowired
	private AluguelCarroRepository aluguelCarroRepository;

	public Pagamento gerarPagamento(Long idPassagem, Long idAluguelCarro, Long idAluguelHotel) {

		Passagem passagem = passagemRepository.findById(idPassagem).get();

		AluguelCarro aluguelCarro = aluguelCarroRepository.findById(idAluguelCarro).get();

		AluguelHotel aluguelHotel = aluguelHotelRepository.findById(idAluguelHotel).get();

		double valorTotal = passagem.getPreço() + aluguelCarro.getValor() + aluguelHotel.getValor();
		
		if(passagem.getUsuário().getId() != aluguelCarro.getUsuário().getId() || passagem.getUsuário().getId() != aluguelHotel.getUsuário().getId()) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insira valores pertencentes ao mesmo usuário");
		}

		Optional<Usuário> usuario = usuárioRepository.findById(passagem.getUsuário().getId());

		Pagamento novoPagamento = new Pagamento();

		novoPagamento.setUsuário(usuario.get());
		novoPagamento.setValor(valorTotal);

		pagamentoRepository.save(novoPagamento);

		return pagamentoRepository.save(novoPagamento);
	}


	public Pagamento compraFinalizada(Pagamento pagamento, Long idPagamento) {

		Pagamento novoPagamento = pagamentoRepository.findById(idPagamento).get();
		
		if(novoPagamento.isCompraFinalizada() == true) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pagamento já realizado");
		}

		novoPagamento.setCompraFinalizada(pagamento.isCompraFinalizada());

		return pagamentoRepository.save(novoPagamento);

	}

}
