package com.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicate 
{
	public static void main(String[] args) 
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(23);
		list.add(34);
		list.add(34);
		System.out.println("Before The Duplicate");
		System.out.println(list);
		System.out.println("");
		
		Set<Integer> collect = list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.toSet());
		System.out.println("Duplicates are " + collect);
	}
}