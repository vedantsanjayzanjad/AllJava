package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class CustomizeSorting
{
	public static void main(String[] args) 
	{
		
		List<String>list = new ArrayList<String>();
		list.add("Vedant");
		list.add("Rushi");
		list.add("Aavani");
		list.add("Jay");
		System.out.println(list);
		
		Comparator<String> custList = (s1,s2) ->
		{
			int a1 = s1.length();
			int a2 = s2.length();
			if (a1 > a2)return 1;
			else if (a2<a1) return -1;
			else return s1.compareTo(s2);
		};
		
		List<String> collect = list.stream().sorted(custList).collect(Collectors.toList());
		
		System.out.println(collect);
	}
}