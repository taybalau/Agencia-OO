package com.trabalhoOO.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoOO.agencia.model.Voo;
import com.trabalhoOO.agencia.service.VooService;

@RequestMapping(value = "/api/user")
@RestController
public class VooController {
	
	@Autowired
	private VooService vooService;
	
	@GetMapping(value="/voo/acharVooPorSaida")
	public ResponseEntity<Voo> getVooByDataSaida(@RequestBody Voo voo){
		
		Voo vooAchado = vooService.getVooByDataSaída(voo);
        
        return new ResponseEntity<>(vooAchado, vooAchado == null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
	
	@GetMapping(value="/voo/acharVooPorChegada")
	public ResponseEntity<Voo> getVooByDataChegada(@RequestBody Voo voo){
		
		Voo vooAchado = vooService.getVooByDataChegada(voo);
        
        return new ResponseEntity<>(vooAchado, vooAchado == null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
	
//	@GetMapping(value="/voo/acharVooPorOrigem/{idOrigem}")
//	public ResponseEntity<Voo> getVooByAeroportoOrigem(@PathVariable String cidade){
//		
//		Voo voo = vooService.getVooByAeroporto(cidade);
//        
//        return new ResponseEntity<>(voo, voo == null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
//    }
//	
//	@GetMapping(value="/voo/acharVooPorDestino/{idDestino}")
//	public ResponseEntity<Voo> getVooByAeroportoDestino(@PathVariable Long idDestino){
//		
//		Voo voo = vooService.getVooByAeroportoDestino(idDestino);
//        
//        return new ResponseEntity<>(voo, voo == null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
//    }


}
