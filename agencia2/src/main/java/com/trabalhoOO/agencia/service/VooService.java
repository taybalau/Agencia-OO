package com.trabalhoOO.agencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoOO.agencia.model.Voo;
import com.trabalhoOO.agencia.repository.VooRepository;

@Service
public class VooService {

	@Autowired
	private VooRepository vooRepository;

	public Voo getVooByDataSaída(Voo voo) {
		
		Voo vooAchado = vooRepository.findVooBySaida(voo.getSaida());

		return vooAchado;

	}
	
	public Voo getVooByDataChegada(Voo voo) {
		
		Voo vooAchado = vooRepository.findVooByChegada(voo.getChegada());

		return vooAchado;

	}


}
