package com.trabalhoOO.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoOO.agencia.model.Passageiro;
import com.trabalhoOO.agencia.service.PassageiroService;

@RequestMapping(value = "/api/user")
@RestController
public class PassageiroController {

	@Autowired
	private PassageiroService passageiroService;

	@GetMapping(value="/passageiro/{idPassageiro}")
	public ResponseEntity<Passageiro> getPassageiroById(@PathVariable Long idPassageiro){

        Passageiro passageiro = passageiroService.getPassageiroById(idPassageiro);
        
        return new ResponseEntity<>(passageiro, passageiro == null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
	
	@PostMapping(value = "/{idPassagem}/cadastrarPassageiro")
	public ResponseEntity<Passageiro> addPassageiro(@RequestBody Passageiro passageiro, @PathVariable Long idPassagem) {

		return new ResponseEntity<>(passageiroService.cadastrarPassageiro(passageiro, idPassagem), HttpStatus.OK);
	}

}
