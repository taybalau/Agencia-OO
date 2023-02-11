package com.trabalhoOO.agencia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoOO.agencia.dto.UsuárioLoginDTO;
import com.trabalhoOO.agencia.model.PessoaFísica;
import com.trabalhoOO.agencia.model.PessoaJurídica;
import com.trabalhoOO.agencia.model.Usuário;
import com.trabalhoOO.agencia.service.UsuárioService;

@RequestMapping(value = "/api/user")
@RestController 
public class UsuárioController {

	@Autowired 
    private UsuárioService usuárioService;
 
    
    @GetMapping(value = {"/usuário/{idUsuário}"})
    public ResponseEntity<Optional<Usuário>> getById(@PathVariable Long idUsuário){

        Optional<Usuário> usuário= usuárioService.getUsuárioById(idUsuário);
        
        return new ResponseEntity<>(usuário, usuário == null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
  
    @PostMapping(value = "/cadastrarPJ")
    public ResponseEntity<PessoaJurídica> addUsuárioPJ(@RequestBody PessoaJurídica usuárioPJ){

       return new ResponseEntity<>(usuárioService.cadastrarUsuarioPJ(usuárioPJ), HttpStatus.OK);
    }
    
    @PostMapping(value = "/cadastrarPF")
    public ResponseEntity<PessoaFísica> addUsuárioPF(@RequestBody PessoaFísica usuárioPF){

       return new ResponseEntity<>(usuárioService.cadastrarUsuarioPF(usuárioPF), HttpStatus.OK);
    }
    
    @PostMapping("/login")
	public ResponseEntity<Optional<UsuárioLoginDTO>> login(@RequestBody Optional<UsuárioLoginDTO> usuário) {
		
    	Optional<UsuárioLoginDTO> loginUsuário = usuárioService.validarCredencial(usuário);
    	
    	return new ResponseEntity<>(loginUsuário, loginUsuário == null  || loginUsuário.isEmpty() ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
	}	
    

}
