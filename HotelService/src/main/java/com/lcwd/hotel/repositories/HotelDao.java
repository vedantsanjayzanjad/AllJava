package com.lcwd.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.hotel.model.Hotel;

@Repository
public interface HotelDao extends JpaRepository<Hotel, String> {

}
