package com.yash.ophs.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ophs.dao.RoomTypeDao;
import com.yash.ophs.model.Medicine;
import com.yash.ophs.model.RoomType;
import com.yash.ophs.service.RoomTypeService;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

	@Autowired
	private RoomTypeDao roomDao;
	
	@Override
	public List<RoomType> getAllRoomTypes() {
		// TODO Auto-generated method stub
		return roomDao.findAll();
	}

	@Override
	public Optional<RoomType> getOneRoomType(int roomTypeId) {
		// TODO Auto-generated method stub
		return roomDao.findById(roomTypeId);
	}

	@Override
	public RoomType addRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		roomDao.save(roomType);
		return roomType;
	}

	@Override
	public RoomType update(RoomType roomType, int roomTypeId) {
		// TODO Auto-generated method stub
		Optional<RoomType> op= roomDao.findById(roomTypeId);
		if(op.isPresent())
		{
			RoomType med  =op.get();
			med.setRoomTypeName(roomType.getRoomTypeName());
			med.setPricePerDay(roomType.getPricePerDay());
			roomDao.save(med);
			System.out.println("RoomTypeUpdate Successfully update successfully");
		}		
		else
		{
			System.out.println("product not found");
		}
		return roomType;
	}

	@Override
	public void deleteRoomType(int roomTypeId) {
		// TODO Auto-generated method stub
		roomDao.deleteById(roomTypeId);
	}

}
