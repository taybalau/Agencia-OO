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

import com.trabalhoOO.agencia.model.AluguelCarro;
import com.trabalhoOO.agencia.service.AluguelCarroService;

@RequestMapping(value = "/api/user")
@RestController
public class AluguelCarroController {
	
	@Autowired
	private AluguelCarroService aluguelCarroService;
	
	@GetMapping(value="/aluguelCarro/{idAluguelCarro}")
	public ResponseEntity<AluguelCarro> getAluguelCarroById(@PathVariable Long idAluguelCarro){

        AluguelCarro aluguelCarro = aluguelCarroService.getAluguelCarroById(idAluguelCarro);
        
        return new ResponseEntity<>(aluguelCarro, aluguelCarro == null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

	@PostMapping(value = "/{idUsuário}/{idCarro}/alugarCarro")
	public ResponseEntity<AluguelCarro> addAluguelCarro(@RequestBody AluguelCarro aluguelCarro, @PathVariable Long idCarro, @PathVariable Long idUsuário) {

		return new ResponseEntity<>(aluguelCarroService.cadastrarAluguelCarro(aluguelCarro, idCarro, idUsuário), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/aluguelCarro/{idAluguelCarro}")
	public ResponseEntity<List<AluguelCarro>> cancelarReservaCarro(@PathVariable Long idAluguelCarro) {

		aluguelCarroService.cancelarReservaCarro(idAluguelCarro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
