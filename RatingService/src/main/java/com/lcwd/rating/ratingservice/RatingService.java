package com.lcwd.rating.ratingservice;

import java.util.List;

import com.lcwd.rating.model.Rating;

public interface RatingService 
{

	Rating createrating(Rating rating);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUser(String userId);
	
	List<Rating> getRatingByHotel(String hotelId);
}
