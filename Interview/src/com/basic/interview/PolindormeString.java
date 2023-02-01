package com.basic.interview;

public class PolindormeString 
{
	public static void main(String[] args)
	{
		String name = "madam";
		String temp = name;
		String reverse = "";
		for(int i = name.length()-1; i >= 0;i--)
		{
			 reverse = reverse + name.charAt(i);
		}
		System.out.println(reverse);
		
		if(reverse.equals(temp))
		{
			System.out.println("Polindrom");
		}
		else
		{
			System.out.println("Not");
		}
	
	}
}
