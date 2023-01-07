package com.lcwd.hotel.service;

import java.util.List;

import com.lcwd.hotel.model.Hotel;

public interface HotelService 
{
	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getOneHotel(String hotelId);
	
}
