package com.lcwd.hotel.exception.globalexception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.exception.ResourceNotFoundException;

@RestController
public class GlobalException 
{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handlerNotFound(ResourceNotFoundException ex)
	{
		Map <String,Object> map = new HashMap<String,Object>();
		map.put("Message",ex.getMessage());
		map.put("Status",HttpStatus.NOT_FOUND);
		map.put("success",false);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
