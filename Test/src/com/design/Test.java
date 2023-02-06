package com.design;

public class Test
{
	private static Test test;
	
	Test()
	{
		
	}
	
	public static Test getData()
	{
		if(test == null)
		{
			test = new Test();
		}
		
		return test;
	}
	
	public static void main(String[] args) {
		
		Test one = Test.getData();
		Test two = Test.getData();
		System.out.println(one.hashCode());
		System.out.println(two.hashCode());
	}
}
