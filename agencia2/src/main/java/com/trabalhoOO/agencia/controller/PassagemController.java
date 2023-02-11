package com.trabalhoOO.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoOO.agencia.model.Passagem;
import com.trabalhoOO.agencia.service.PassagemService;

@RequestMapping(value = "/api/user")
@RestController
public class PassagemController {

	@Autowired
	private PassagemService passagemService;
	
	@GetMapping(value="/passagem/{idPassagem}")
	public ResponseEntity<Passagem> getPassagemById(@PathVariable Long idPassagem){

        Passagem passagem = passagemService.getPassagemById(idPassagem);
        
        return new ResponseEntity<>(passagem, passagem== null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
	
	@PostMapping(value = "/{idUsuário}/{idVoo}/cadastrarPassagem")
	public ResponseEntity<Passagem> addPassagem(@RequestBody Passagem passagem, @PathVariable Long idUsuário,
			@PathVariable Long idVoo) {

		return new ResponseEntity<>(passagemService.cadastrarPassagem(passagem, idVoo, idUsuário), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/passagem/{idPassagem}")
	public ResponseEntity<List<Passagem>> cancelarPassagem(@PathVariable Long idPassagem) {

		passagemService.cancelarPassagem(idPassagem);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
