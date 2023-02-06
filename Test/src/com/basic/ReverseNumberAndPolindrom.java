package com.basic;

public class ReverseNumberAndPolindrom 
{
	public static void main(String[] args) 
	{
		int no = 121;
		int rev =0;
		int newNo = no;
		
		for(;no!=0;no=no/10)
		{
			int remainder = no % 10;
			rev = rev * 10 + remainder;
		}
		
		System.out.println("Reverse Number Is " + rev);
		
		if(rev == newNo)
		{
			System.out.println("Polindrom Number");
		}
		
		else
		{
			System.out.println("Not a Polindrome");
		}
		
		//StringBuffer
		StringBuffer sf = new StringBuffer(String.valueOf(newNo));
		System.out.println(sf.reverse());
		
		//StringBuilder
		StringBuilder sb = new StringBuilder();
		StringBuilder reverse = sb.append(newNo).reverse();
		System.out.println(reverse);
		
	}
}
