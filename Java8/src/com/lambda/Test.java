package com.lambda;

interface inter {
	public void get();
}

interface interOne {
	public void getInt(int a);
}

interface interTwo {
	public void getInt(int a, int b);
}

interface interString {
	public String getString();
}

public class Test {
	public static void main(String[] args) {
		// First InterFace
		inter i = () -> System.out.println("This is First Method");
		i.get();

		// Second InterFace
		interOne j = a -> System.out.println("The Number Is " + a);
		j.getInt(6);

		// Third InterFace
		interTwo k = (a, b) -> System.out.println("The Sum Of Number Is " + (a + b));
		k.getInt(6, 6);

		// Fourth InterFace
		interString l = () -> 
		{
			return "VEDANT";
		};
			
		System.out.println(l.getString());
	}
}