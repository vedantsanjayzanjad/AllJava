package com.string;

public class ReverseStringAndPolindromString {
	public static void main(String[] args) {

		String str = "MADAM";
		String rev = "";
		String newStr = str;

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println(rev);
		
		if(newStr.equals(rev))
		{
			System.out.println("Poindrome");
		}
		else
		{
			System.out.println("Not a Polindrome");
		}
		
		//StringBuffer
		StringBuffer sf = new StringBuffer(str);
		sf.reverse();
		System.out.println(sf);
		
		
		//STringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.reverse();
		System.out.println(sb);
	}
}
