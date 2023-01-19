package com.array;
//byte->short>int>long>floadt>double
//String>object

public class Overloading 
{

	public void m1(int str)

	{
		System.out.println("ok");
	}
	
	public void m1(Object o)
	{
		System.out.println("ok new");
	}
	
	public static void main(String[] args) {
		Overloading ov = new Overloading();
		ov.m1(null);
		
		
	}
}
