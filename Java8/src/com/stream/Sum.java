package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sum 
{
	
		public static void main(String[] args) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(12);
			list.add(23);
			list.add(34);
			list.add(67);
			System.out.println("Before The Sum");
			System.out.println(list);
			System.out.println("");
			
			//By Sum Method
			//int sum = list.stream().mapToInt(e -> e).sum();
			
			//By Reduce Method
			Optional<Integer> sum = list.stream().reduce((a,b) -> (a + b));
			System.out.println("After The Sum");
			System.out.println(sum);
	}
}
