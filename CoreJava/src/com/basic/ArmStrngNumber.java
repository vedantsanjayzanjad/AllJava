package com.basic;

public class ArmStrngNumber 
{
	public static void main(String[] args) 
	{
		int number = 153;
		int rev = 0;
		int temp =number;
		for(;number != 0;number = number /10)
		{
			int remainder = number % 10;
			rev  = remainder * remainder * remainder + rev;
		}
		//System.out.println(rev);
		
		if(temp == rev)
		{
			System.out.println("are");
		}
		else 
			{
				System.out.println("are not");
			}
	}
}
