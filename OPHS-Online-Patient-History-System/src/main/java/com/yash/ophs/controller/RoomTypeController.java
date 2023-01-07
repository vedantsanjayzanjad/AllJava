package com.yash.ophs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.ophs.model.RoomType;
import com.yash.ophs.serviceimplementation.RoomTypeServiceImpl;

@RestController
@RequestMapping("/roomType")
public class RoomTypeController {

	@Autowired
	private RoomTypeServiceImpl roomServImpl;
	
	@GetMapping("/getAllRoomType")
	public List<RoomType> getAllRoomType() {

		return this.roomServImpl.getAllRoomTypes();
	}

	@GetMapping("/getOneRoomType/{roomTypeId}")
	public Optional<RoomType> getDoctorById(@PathVariable String roomTypeId) {

		return roomServImpl.getOneRoomType(Integer.parseInt(roomTypeId));
	}

	@PostMapping("/addRoomType")
	public RoomType addDoctor(@RequestBody RoomType roomType) {
		return this.roomServImpl.addRoomType(roomType);

	}

	@PutMapping("/updateRoomType/{roomTypeId}")
	public RoomType update(@RequestBody RoomType roomType, @PathVariable int roomTypeId) {
		return this.roomServImpl.update(roomType,roomTypeId);

	}

	@DeleteMapping("/deleteRoomType/{roomTypeId}")
	public void deleteMedicine(@PathVariable String roomTypeId) {
		roomServImpl.deleteRoomType(Integer.parseInt(roomTypeId));
	}
	
	
}
