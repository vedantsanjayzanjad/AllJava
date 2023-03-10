package com.singleton;

public class Singleton
{
	private static Singleton singleton;
	
	private Singleton()
	{
		
	}
	
	public static synchronized Singleton getData()
	{
		if(singleton == null)
		{
			singleton = new Singleton();
		}
		return singleton;
	}
	
	public static void main(String[] args) 
	{
		Singleton test = Singleton.getData();
		Singleton testOne = Singleton.getData();
		System.out.println(test.hashCode());
		System.out.println(testOne.hashCode());
	}
}
