package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class EvenAndOdd
{
	public static void main(String[] args) 
	{
		List <Integer>list = new ArrayList<Integer>();
		list.add(22);
		list.add(223);
		list.add(323);
		list.add(262);
		list.add(210);
//		List<Integer> get = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
//		System.out.println(get);
		
		List<Integer> get = list.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
		System.out.println(get);
	}
}