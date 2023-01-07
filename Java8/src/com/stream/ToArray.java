package com.stream;

import java.util.*;

public class ToArray 
{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(23);
		list.add(34);
		list.add(67);
		System.out.println("Before The Array");
		System.out.println(list);
		
		   Integer[] array = list.stream().toArray(Integer [] :: new);
		   System.out.println();
		   for(int i : array)
		   {
			   System.out.println(i);
		   }
	}
	
}
