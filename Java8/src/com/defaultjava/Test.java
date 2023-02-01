package com.defaultjava;

interface inter {
	 default void m1() {
		System.out.println("This is m1() method");
	}

}

interface interOne {
	default void m2() {
		System.out.println("This is m2() method");
	}

}


public class Test implements inter,interOne {
	
	public void test()
	{
		//System.out.println("This is First Method");
		//inter.super.m1();
		interOne.super.m2();
	}
	
	public static void main(String[] args) 
	{
		interOne i = new Test();
		i.m2();
	}
}
