package com.trabalhoOO.agencia.service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trabalhoOO.agencia.model.AluguelCarro;
import com.trabalhoOO.agencia.model.Carro;
import com.trabalhoOO.agencia.model.Usuário;
import com.trabalhoOO.agencia.repository.AluguelCarroRepository;
import com.trabalhoOO.agencia.repository.CarroRepository;
import com.trabalhoOO.agencia.repository.UsuárioRepository;

@Service
public class AluguelCarroService {
	
	@Autowired
	private AluguelCarroRepository aluguelCarroRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private UsuárioRepository usuarioRepository;
	
	public AluguelCarro getAluguelCarroById(Long idCarro) {
		
		return aluguelCarroRepository.findById(idCarro).get();
	}

	public double calcularDiáriaCarro(AluguelCarro aluguelCarro, double preçoDaDiária) {

		Long qtdDiária = ChronoUnit.DAYS.between(aluguelCarro.getDataInício(), aluguelCarro.getDataFinal());

		return qtdDiária * preçoDaDiária;
	}

	public AluguelCarro cadastrarAluguelCarro(AluguelCarro aluguelCarro, Long idCarro, Long idUsuário) {

		Optional<Usuário> usuario = usuarioRepository.findById(idUsuário);

		Carro carro = carroRepository.findById(idCarro).get();

		AluguelCarro novoAluguelCarro = new AluguelCarro();

		double preçoDaDiária = 0;

		switch (carro.getModelo()) {

		case "Hyundai HB20":
			preçoDaDiária = 200;
		case "Honda HRV":
			preçoDaDiária = 240;
		case "Chevrolet Ônix":
			preçoDaDiária = 150;
		case "Nissan Versa":
			preçoDaDiária = 87;
			
		}

		double valorTotal = calcularDiáriaCarro(aluguelCarro, preçoDaDiária);
		
		if(valorTotal == 0) {
			valorTotal = preçoDaDiária;
		}

		novoAluguelCarro.setDataFinal(aluguelCarro.getDataFinal());
		novoAluguelCarro.setDataInício(aluguelCarro.getDataInício());
		novoAluguelCarro.setCarro(carro);
		novoAluguelCarro.setUsuário(usuario.get());
		novoAluguelCarro.setValor(valorTotal);

		return aluguelCarroRepository.save(novoAluguelCarro);
	}
	
	public void cancelarReservaCarro(Long idCarro) {
		
		aluguelCarroRepository.deleteById(idCarro);
	}

}
