package com.defaultjava;

interface inter {
	 default void m1() {
 		System.out.println("This is m1() method");
	}

}

interface interOne {
	default void m2() {
		for(int i = 0;i<10;i++)
		{
		System.out.println("This is m2() method " + i);
		}
	}

}


public class Test implements inter,interOne {
	
	public void test()
	{
		//System.out.println("This is First Method");
		//inter.super.m1();
		interOne.super.m2();
		inter.super.m1();
	}
	
	public static void main(String[] args) 
	{
//		interOne i = new Test();
		Test i = new Test();
		i.test();
	}
}
