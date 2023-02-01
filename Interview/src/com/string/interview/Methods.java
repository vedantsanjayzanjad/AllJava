package com.string.interview;

public class Methods 
{
	public static void main(String[] args) 
	{
		String str = "   Vedant zanjad    ";
		//charAt Method to return the value at a particular index
		System.out.println(str.charAt(2));
		
		//boolean contains return the boolean condition when it will return
		//the values 
		System.out.println(str.contains("V"));
		
		//subString(int i) from index i
		System.out.println(str.substring(2));
		
		//substring(int i, int j)
		System.out.println(str.substring(2, 4));
		
		//concat concate the string to the end
		System.out.println(str.concat("Zanjad"));
		
		//indexOf returns the content index
		System.out.println(str.indexOf("e"));
		
		//lastIndexOf return the content index
		System.out.println(str.lastIndexOf("a"));
		
		//equals and equalIgnoreCase
		System.out.println(str.equals("Vedant"));
		
		//int compareTo(String anotherString)
		//it will compare the string lexicographically
		String s = "Akshay";
		System.out.println(str.compareTo(s));
		//if str - s = out
		//out < 0 //str will comes first 
		//out > 0 //str will second
		//out = 0 //str and s are equals
		
		//int compareToIgnoreCases
		//will ignore the case
		
		
		//uppercase
		//lowercase
		
		
		//trim
		//To remove the whitespaces
		System.out.println(str.trim());
		
		//replace
		System.out.println(str.replace('V', 'L'));
		
	}
}
