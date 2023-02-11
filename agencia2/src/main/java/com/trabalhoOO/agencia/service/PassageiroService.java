package com.trabalhoOO.agencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.trabalhoOO.agencia.model.Passageiro;
import com.trabalhoOO.agencia.model.Passagem;
import com.trabalhoOO.agencia.repository.PassageiroRepository;
import com.trabalhoOO.agencia.repository.PassagemRepository;

@Service
public class PassageiroService {

	@Autowired
	private PassageiroRepository passageiroRepository;
	
	@Autowired
	private PassagemRepository passagemRepository;
	
	public Passageiro getPassageiroById(Long idPassageiro) {
		
		return passageiroRepository.findById(idPassageiro).get();
	}

	public Passageiro cadastrarPassageiro(Passageiro passageiro, Long idPassagem) {
		
		Passagem passagem = passagemRepository.findById(idPassagem).get();
		Passageiro novoPassageiro = new Passageiro();
		
		novoPassageiro.setNome(passageiro.getNome());
		novoPassageiro.setCPF(passageiro.getCPF());
		novoPassageiro.setNascimento(passageiro.getNascimento());
		novoPassageiro.setPassagem(passagem);
		novoPassageiro.setTipo(passageiro.getTipo());
		if(passagem.getVoo().getDestino().getInternacional() == true) {
			if(passageiro.getPassaporte() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Necessário apresentar passaporte");
			}else {
				novoPassageiro.setPassaporte(passageiro.getPassaporte());
			}	
		}
		return passageiroRepository.save(novoPassageiro);
	}
	
}
