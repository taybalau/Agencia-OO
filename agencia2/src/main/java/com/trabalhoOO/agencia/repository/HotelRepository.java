package com.trabalhoOO.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoOO.agencia.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
