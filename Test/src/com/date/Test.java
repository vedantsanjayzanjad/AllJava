package com.date;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		
		LocalDate date =  LocalDate.of(2022,7,7);//7
		//System.out.println(date);
		//System.out.println(date);
		//LocalDate plusDays = date.plusDays(10);
		//System.out.println(plusDays);
		LocalDate date1 =  LocalDate.of(2022,7,12);//12
		LocalDate date2 =  LocalDate.of(2022,7,10);//compare//10
		//System.out.println(date2.plusDays(7));
		if(date.isBefore(date2) && date1.isAfter(date2));
		{
			System.out.println("count ");
			date2.plusDays(8);
			System.out.println(date2.plusDays(4));//11
		}	
	}
}
