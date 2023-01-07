package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




public class PrimeNumber {
//	public static boolean isPrime(int number) {
//		
//		if(number == 0 || number == 1)
//		{
//			return false;
//		}
//		
//		if(number == 2 || number == 3 || number == 5 || number == 7 || number == 9 )
//		{
//			return true;
//		}
//		
//		if(number % 2 == 0 || number % 3 == 0|| number % 5 == 0 || number  % 7 == 0 || number  % 9 == 0 )
//		{
//			return false;
//		}
//		
//		return true;
//	}
	
	public static boolean isPrime(int number)
	{
		for(int i =2; i <= number / 2; i++)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(23);
		list.add(34);
		list.add(67);
		System.out.println("Before The Sum");
		System.out.println(list);
		System.out.println("");
		
		List<Integer> collect = list.stream().filter(PrimeNumber :: isPrime).collect(Collectors.toList());
		System.out.println(collect);
	}
}