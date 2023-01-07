package com.lcwd.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.model.Hotel;
import com.lcwd.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController 
{
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/addHotels")
	public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).
		body(hotelService.createHotel(hotel));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAllHotels()
	{
		return ResponseEntity.status(HttpStatus.FOUND).
				body(hotelService.getAllHotel());
		
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getOneHotel(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).
				body(hotelService.getOneHotel(hotelId));
	}
}
