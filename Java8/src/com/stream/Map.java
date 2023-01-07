package com.stream;

import java.util.ArrayList;
import java.util.List;

public class Map 
{
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(34);
		list.add(23);
		list.add(6);
		list.add(7);
		System.out.println("Before The MAx");
		System.out.println(list);
		System.out.println("");
		
		double avg = list.stream().map(e-> e*e).filter(e -> e % 2 == 0).mapToInt(a -> a).average().getAsDouble();
		System.out.println(avg);
		
	}
}