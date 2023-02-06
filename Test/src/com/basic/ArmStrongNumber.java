package com.basic;

public class ArmStrongNumber 
{	
	public static void main(String[] args) 
	{
		int no = 153;
		int rev = 0;
		int newNo = no;
		for(;no!=0;no=no/10)
		{
			int remainder = no % 10;
			rev = remainder*remainder*remainder + rev;
		}

		if(newNo == rev)
		{
			System.out.println("ArmStrong Number");
		}
		else
		{
			System.out.println("Not A ArmStrong");
		}
	}
}
