package com.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap 
{
	public static void main(String[] args)
	{
		List<String> listOne  = Arrays.asList("Vedant","Akshay","Sachin");
		List<String> listTwo  = Arrays.asList("One","Two","Three");
		List<String> listThree  = Arrays.asList("Ok","No","Problem");
		
		
	List<List<String>> newList = new ArrayList<>();
	
	newList.add(listThree);
	newList.add(listTwo);
	newList.add(listOne);
	
	System.out.println(newList);
	List<String> collect = newList.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());
	System.out.println(collect);
	}
}
