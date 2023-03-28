package com.string;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


public class StringToDate 
{
	public static void main(String[] args) throws ParseException {
		//Using Date
		String str = "31/12/1998";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
		System.out.println(date);
		
		//LocalDate
		String no = "2012-12-10";
		LocalDate bo = LocalDate.parse(no);
		System.out.println(bo);
		
		//LocalTime
		String times = "10:30:10";
		LocalTime time = LocalTime.parse(times);
		System.out.println(time);

		
	}
}
