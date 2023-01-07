package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting 
{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(34);
		list.add(23);
		list.add(6);
		list.add(7);
		System.out.println("Before The Sorting");
		System.out.println(list);
		System.out.println("");
		
		//Descending
		//List<Integer> collect = list.stream().sorted((i1,i2)->- i1.compareTo(i2)).collect(Collectors.toList());
		//List<Integer> collect = list.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList());
		
		//Ascending
		List<Integer> collect = list.stream().sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println(collect);
	}
}