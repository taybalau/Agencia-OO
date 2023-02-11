package com.trabalhoOO.agencia.service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoOO.agencia.model.AluguelHotel;
import com.trabalhoOO.agencia.model.Hotel;
import com.trabalhoOO.agencia.model.Usuário;
import com.trabalhoOO.agencia.repository.AluguelHotelRepository;
import com.trabalhoOO.agencia.repository.HotelRepository;
import com.trabalhoOO.agencia.repository.UsuárioRepository;

@Service
public class AluguelHotelService {
	
	@Autowired
	private AluguelHotelRepository aluguelHotelRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private UsuárioRepository usuárioRepository;
	
	public AluguelHotel getAluguelHotelById(Long idHotel) {
		
		return aluguelHotelRepository.findById(idHotel).get();
	}
	
	public double calcularDiáriaHotel(AluguelHotel aluguelHotel, double valorDaDiária) {
		
		Long qtdDiária = ChronoUnit.DAYS.between(aluguelHotel.getDataInício(), aluguelHotel.getDataFinal());
		
		return qtdDiária * valorDaDiária ;
	}
	
	public AluguelHotel cadastrarAluguelHotel(AluguelHotel aluguelHotel, Long idHotel, Long idUsuário) {
		
		Optional<Usuário> usuario = usuárioRepository.findById(idUsuário);
		
		Hotel hotel = hotelRepository.findById(idHotel).get();
		
		AluguelHotel novoAluguelHotel = new AluguelHotel();
		
		double valorDaDiária = 0;
		
		switch(hotel.getEstrelas()) {
		
		case 1: 
			valorDaDiária = 150;
		case 2:
			valorDaDiária = 250;
		case 3:
			valorDaDiária = 350;
		case 4:
			valorDaDiária = 560;
		case 5:
			valorDaDiária = 1200;
		}
		
		double valorTotal = calcularDiáriaHotel(aluguelHotel, valorDaDiária);
		
		novoAluguelHotel.setDataFinal(aluguelHotel.getDataFinal());
		novoAluguelHotel.setDataInício(aluguelHotel.getDataInício());
		novoAluguelHotel.setHotel(hotel);
		novoAluguelHotel.setUsuário(usuario.get());
		novoAluguelHotel.setValor(valorTotal);
		
		return aluguelHotelRepository.save(novoAluguelHotel);
	}

	public void cancelarReservaHotel(Long idHotel) {
		
		aluguelHotelRepository.deleteById(idHotel);
	}
}
