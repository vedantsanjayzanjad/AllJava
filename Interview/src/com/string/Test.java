package com.string;

public class Test 
{
	public static void main(String[] args) {
		
		String s = "vedant";
		String name  = new String("Vedant");
		String ok = "vedant";
		System.out.println(s.equals(ok));
		String s3 = s.intern();
		System.out.println(s3.equals(s)); //contained
		System.out.println(s3 == s);//refrences
		System.out.println(s == ok);
	}
}
