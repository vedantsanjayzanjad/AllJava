package com.basic;

public class FibbonaciiSeries 
{
	public static void main(String[] args) 
	{
		int a =0,b=1;
		System.out.println(a);//1
		for(int i = 1;i <= 10;i++)
		{
			int c = a + b;
			a=b;
			b=c;
			
			System.out.println(c);
		}
	}
}
