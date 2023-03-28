package com.string;

public class Objects {

	
	boolean isPrime(String str) 
	{
		try
		{
		int number = Integer.parseInt(str);
		if(number == 0 || number == 1)
		{
			return false;
		}
		
		if(number == 2 || number == 3 || number == 5 || number == 7 )
		{
			return true;
		}
		
		if(number % 2 == 0 || number % 3 == 0|| number % 5 == 0 || number  % 7 == 0)
		{
			return false;
		}
		return true;	
		}
		catch(NumberFormatException e)
		{
			System.out.println(e);
		}
		return false;
	}

	public static void main(String[] args) 
	{
		Objects obj = new Objects();
		System.out.println(obj.isPrime("12"));
	}
}
