package com.trabalhoOO.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoOO.agencia.model.AluguelHotel;

@Repository
public interface AluguelHotelRepository extends JpaRepository<AluguelHotel, Long> {

}
