package com.staticjava;

interface inter {
	public static void m1() {
		System.out.println("This is m1() method");
	}

}

interface interOne {
	public static void m2() {
		System.out.println("This is m2() method");
	}
}

public class Test implements inter,interOne {
	public static void main(String[] args) {
		inter.m1();
		interOne.m2();
	}
}
