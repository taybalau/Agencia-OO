package com.trabalhoOO.agencia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.trabalhoOO.agencia.model.Passagem;
import com.trabalhoOO.agencia.model.Usuário;
import com.trabalhoOO.agencia.model.Voo;
import com.trabalhoOO.agencia.repository.PassagemRepository;
import com.trabalhoOO.agencia.repository.UsuárioRepository;
import com.trabalhoOO.agencia.repository.VooRepository;

@Service
public class PassagemService {
	
	@Autowired
	private PassagemRepository passagemRepository;
	
	@Autowired
	private UsuárioRepository usuárioRepository;
	
	@Autowired
	private VooRepository vooRepository;
	
	public Passagem getPassagemById(Long idPassagem) {
		
		return passagemRepository.findById(idPassagem).get();
		
	}
	
	public Passagem cadastrarPassagem(Passagem passagem, Long idVoo, Long idUsuário ) {
		          
		Optional<Voo> voo = vooRepository.findById(idVoo);
		
		Optional<Usuário> usuario = usuárioRepository.findById(idUsuário);
		
		Passagem compararAcento = passagemRepository.findPassagemByAcento(passagem.getAcento());
		
		if(compararAcento != null) {
			Voo compararVoo = compararAcento.getVoo();
			
			if(compararVoo == compararAcento.getVoo())
				
			 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Acento já ocupado! Escolha um novo.");
		}
		
		Passagem novaPassagem = new Passagem();
		
		String paísAeroporto = voo.get().getDestino().getNome();
		
		switch(paísAeroporto) {
		
		case "Aeroporto de Brasília":
			 novaPassagem.setPreço(250.39);
			 break;
		case "Aeroporto de Congonhas":
			 novaPassagem.setPreço(289.40);
			 break;
		case "Aeroporto John F. Kennedy":
			 novaPassagem.setPreço(2500.00);
			 break;
		case "Aeroporto de Tóquio":
			 novaPassagem.setPreço(4573.20);
			 break;
		case "Aeroporto Pinto Martins":
			 novaPassagem.setPreço(1400.77);
			 break;
		}
		
		novaPassagem.setAcento(passagem.getAcento());
		novaPassagem.setVoo(voo.get());
		novaPassagem.setUsuário(usuario.get());
		
		return passagemRepository.save(novaPassagem);
	}
	
	public void cancelarPassagem (Long idPassagem){

		  passagemRepository.deleteById(idPassagem);
	  }
}
