package com.stream;

import java.util.ArrayList;
import java.util.List;

public class MaxAndMin 
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
		
		//Maximum
		Integer max = list.stream().max((i1,i2) -> i1.compareTo(i2)).get();
		System.out.println(max);
		
		//Minimum
		Integer min = list.stream().min((i1,i2) -> i1.compareTo(i2)).get();
		System.out.println(min);
	}
}
