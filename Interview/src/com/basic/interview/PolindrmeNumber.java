package com.basic.interview;

public class PolindrmeNumber
{
	public static void main(String[] args) {
		int num = 121;
		int temp = num;
		int rev = 0;
		for(;num != 0; num=num/10)
		{
			int remainder = num % 10;
			rev = rev * 10 + remainder;
		}	
		if(temp == rev)
		{
			System.out.println("polindrom");
		}
		else
		{
			System.out.println("Not");
		}
	}
}
