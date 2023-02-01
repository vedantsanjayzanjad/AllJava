package com.set;

import java.util.*;

public class Test {
	public static void main(String[] args) {

//1)Hashset
		
		//when we have to represent group of object
		//in a single entity where insertion order is not preserved 
		//and duplicates are not allowed
		//if we try to add duplicate then there will no compile time error
		//and it will override the values with latest values
		//WHen we have to seacrh operation then we have to go for the hashset
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(12);
		set.add(12);
		set.add(34);
		set.add(67);
		//System.out.println(set);
	
		
//2)LinkedHashset
		//Same as the hashset but the main differnce is its maintain insertion ordered
		//and we will go for the linkedHashset whent there chache based application and in that we have
		//to maintain a insertion with the predicatable insertion order
		
//		Set<Integer> set = new LinkedHashSet<Integer>();
//		set.add(12);
//		set.add(12);
//		set.add(34);
//		set.add(67);
//		System.out.println(set);
		
//sortedset
		//it will order the object in some sorting order
	
//TreeSet
		//Hetrogenous elements are not accetable throws class cast exception
		//null values are not possible throws nullpointer exception
		//Sorted in ascending order
		//insertion order is not preserved and duplicates are not allowed
//		Set<Integer> set = new TreeSet<Integer>();
//		set.add(12);
//		set.add(12);
//		set.add(34);
//		set.add(12);
//		System.out.println(set);
	}
}
