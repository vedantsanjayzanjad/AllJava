package com.task.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.Holiday;
import com.task.payloads.ApiResponse;
import com.task.serviceimpl.HolidayImpl;

@RestController
@RequestMapping("/holiday")
@CrossOrigin(allowedHeaders = "*")
public class HolidayController {

	@Autowired
	private HolidayImpl holidayserv;
	
	@PostMapping("/add")
	public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) throws Exception
	{		
		Holiday createHoliday = this.holidayserv.createHoliday(holiday);
		System.out.println("After");
		return new ResponseEntity<>(createHoliday,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{holidayId}")
	public ResponseEntity<ApiResponse> deleteHolidayById(@PathVariable int holidayId)
	{
		this.holidayserv.deleteHolidayById(holidayId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Holiday is deleted !!!", true), HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Holiday>> getAllHoliday()
	{
		List<Holiday> allHoliday = this.holidayserv.getAllHoliday();
		return new ResponseEntity<List<Holiday>>(allHoliday,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getOne/{holidayId}")
	public ResponseEntity<Holiday> getOneHoliday(@PathVariable int holidayId)
	{
		Holiday oneHoliday = this.holidayserv.getOneHoliday(holidayId);
		return new ResponseEntity<>(oneHoliday,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/{holidayId}")
	public ResponseEntity<Holiday> updateHoliday(@PathVariable int holidayId,@RequestBody Holiday holiday)
	{
		Holiday updateHoliday = this.holidayserv.updateHoliday(holidayId, holiday);
		return new ResponseEntity<>(updateHoliday,HttpStatus.ACCEPTED);
	}
}

//		Date add = new SimpleDateFormat("dd/MM/yyyy").parse(string);
//		System.out.println(date);