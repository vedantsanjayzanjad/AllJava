package com.string;

public class RemoveAllWhiteSpaces 
{
	public static void main(String[] args) {
		
		String str = "My $Name (Is #@Vedant";
		str = str.replaceAll("\\s", "");
		System.out.println(str);
		
		
		//specialCharactorOnly
		str = str.replaceAll("[^a-zA-Z]", "");
		System.out.println(str);
	}
}
