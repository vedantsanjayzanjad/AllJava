package com.string;

public class AllMethod 
{
	public static void main(String[] args) 
	{
		String s = "vednat";
		String s1 = "Akshay";
		
		//2)CharAt
		System.out.println(s.charAt(3));
		
		//2)compareTo :: The Java String class compareTo() method compares the given string
		//with the current string lexicographically. 
		//It returns a positive number, negative number, or 0.
		System.out.println(s.compareTo(s1));
		
		//3)Concat :: will combined the string at the end of the string
		//System.out.println(s.concat(" OK "));
		String name = s.concat(s1);
		System.out.println(name);
		
		//The Java String class contains() :: method searches the sequence of characters 
		//in this string. 
		//It returns true if the sequence of char values is found in
		//this string otherwise returns false.
		System.out.println(s.contains("v"));
	
	}
}
