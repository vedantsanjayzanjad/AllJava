package com.lcwd.rating.ratingservice.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.model.Rating;
import com.lcwd.rating.ratingservice.RatingService;
import com.lcwd.rating.repositories.RatingDao;

@Service
public class RatingImpl implements RatingService
{

	@Autowired
	private RatingDao ratingDao;
	
	@Override
	public Rating createrating(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return this.ratingDao.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return this.ratingDao.findAll();
	}

	@Override
	public List<Rating> getRatingByUser(String userId) {
		
		return this.ratingDao.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotel(String hotelId) {
	
		return ratingDao.findByHotelId(hotelId);
	}
}
