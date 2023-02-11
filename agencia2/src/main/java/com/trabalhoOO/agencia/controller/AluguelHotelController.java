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

import com.trabalhoOO.agencia.model.AluguelHotel;
import com.trabalhoOO.agencia.model.Passageiro;
import com.trabalhoOO.agencia.model.Passagem;
import com.trabalhoOO.agencia.service.AluguelHotelService;

@RequestMapping(value = "/api/user")
@RestController
public class AluguelHotelController {
	
	@Autowired
	private AluguelHotelService aluguelHotelService;
	
	@GetMapping(value="/aluguelHotel/{idHotel}")
	public ResponseEntity<AluguelHotel> getAluguelHotelById(@PathVariable Long idAluguelHotel){

        AluguelHotel aluguelHotel = aluguelHotelService.getAluguelHotelById(idAluguelHotel);
        
        return new ResponseEntity<>(aluguelHotel, aluguelHotel == null  ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }
	
	@PostMapping(value = "/{idUsuário}/{idHotel}/alugarHospedagem")
	public ResponseEntity<AluguelHotel> addAluguelHotel(@RequestBody AluguelHotel aluguelHotel, @PathVariable Long idHotel, @PathVariable Long idUsuário) {

		return new ResponseEntity<>(aluguelHotelService.cadastrarAluguelHotel(aluguelHotel, idHotel, idUsuário), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/aluguelHotel{idAluguelHotel}")
	public ResponseEntity<List<AluguelHotel>> cancelarReservaHotel(@PathVariable Long idAluguelHotel) {

		aluguelHotelService.cancelarReservaHotel(idAluguelHotel);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
