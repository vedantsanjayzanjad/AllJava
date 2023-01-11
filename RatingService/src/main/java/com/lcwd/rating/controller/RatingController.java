package com.lcwd.rating.controller;

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

import com.lcwd.rating.model.Rating;
import com.lcwd.rating.ratingservice.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController 
{
	@Autowired
	private RatingService ratingService;

	@PostMapping("/addRating")
	public ResponseEntity<Rating> creatrating(@RequestBody Rating rating)
	{
		return ResponseEntity.
		status(HttpStatus.CREATED).body(this.ratingService.createrating(rating));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>>getAll()
	{
		return ResponseEntity.
		status(HttpStatus.FOUND).body(this.ratingService.getAllRating());

	}
	
	@GetMapping("user/{userId}")
	public ResponseEntity<List<Rating>>getRatingByUser(@PathVariable String userId)
	{
		return ResponseEntity.
		status(HttpStatus.FOUND).body(this.ratingService.getRatingByUser(userId));

	}
	
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>>getRatingByHotel(@PathVariable String hotelId)
	{
		return ResponseEntity.
		status(HttpStatus.FOUND).body(this.ratingService.getRatingByHotel(hotelId));
	}
}