package com.lcwd.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "micro_hotels")
public class Hotel 
{
	
	@Id
	private String hotelId;
	
	private String hotelName;
	
	private String location;
	
	private String about;
}
