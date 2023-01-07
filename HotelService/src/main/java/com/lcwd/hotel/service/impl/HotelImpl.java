package com.lcwd.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.exception.ResourceNotFoundException;
import com.lcwd.hotel.model.Hotel;
import com.lcwd.hotel.repositories.HotelDao;
import com.lcwd.hotel.service.HotelService;

@Service
public class HotelImpl implements HotelService
{
	@Autowired
	private HotelDao hotelDao;

	@Override
	public Hotel createHotel(Hotel hotel) {
		
		String random = UUID.randomUUID().toString();
		hotel.setId(random);
		Hotel savedHotel = this.hotelDao.save(hotel);
		return savedHotel;
	}

	@Override
	public List<Hotel> getAllHotel() {
		return this.hotelDao.findAll();
	}

	@Override
	public Hotel getOneHotel(String hotelId) {
		return this.hotelDao.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel With Given Id Is Not Found"));
	}
}
