package com.basic;

public class PolindromeNumber 
{
	public static void main(String[] args) 
	{
		int number = 121;
		int rev = 0;
		int temp = number;
		
		for(;number != 0; number = number /10)
			{
				int remainder = number % 10;
				rev = rev *10 + remainder;
			}
			//System.out.println(rev);
			
			if(temp == rev)
			{
				System.out.println("polindrome");
			}
			else
			{
				System.out.println("NOt a");
			}
	}
}
