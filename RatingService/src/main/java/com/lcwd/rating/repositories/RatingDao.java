package com.lcwd.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.rating.model.Rating;

@Repository
public interface RatingDao extends JpaRepository<Rating, String> 
{
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
}
