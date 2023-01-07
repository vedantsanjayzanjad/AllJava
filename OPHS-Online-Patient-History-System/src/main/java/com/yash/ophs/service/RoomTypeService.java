package com.yash.ophs.service;

import java.util.List;
import java.util.Optional;

import com.yash.ophs.model.RoomType;

public interface RoomTypeService {
	public List<RoomType> getAllRoomTypes();

	public Optional<RoomType> getOneRoomType(int roomTypeId);

	public RoomType addRoomType(RoomType roomType);

	public RoomType update(RoomType roomType, int roomTypeId);

	public void deleteRoomType(int roomTypeId);
}
