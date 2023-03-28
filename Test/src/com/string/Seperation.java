package com.string;

public class Seperation {
	public static void main(String args[]) {
		String a = "java123point456";
		String str = "";
		String str1 = "";
		for(int i =0;i<a.length();i++)
		{
			char c = a.charAt(i);
			
			if(c>='a' && c <='z' || c>='A' && c <='Z')
			{
				str = str + c;
			}
			

			if(c>='0' && c <='9')
			{
				str1 = str1 + c;
			}
			
		}
		
		System.out.println(str);
		System.out.println(str1);
		
		
		
	}
}
