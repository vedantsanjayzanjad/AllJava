package com.yash.ophs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private int roomTypeId;
	private String roomTypeName;
	private double pricePerDay;
	
	RoomType()
	{
		
	}
	
	
	public RoomType(int roomTypeId, String roomTypeName, double pricePerDay) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.pricePerDay = pricePerDay;
	}


	public int getRoomTypeId() {
		return roomTypeId;
	}


	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}


	public String getRoomTypeName() {
		return roomTypeName;
	}


	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}


	public double getPricePerDay() {
		return pricePerDay;
	}


	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
	
	
}
