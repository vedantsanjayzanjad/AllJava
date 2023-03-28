package com.string;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class ConsanantsAndVowels {

	public static void main(String[] args) {
		
		String str = "Hi This u is Vedant Zanjad";
		for(int i =0;i<str.length();i++)
		{
			if(str.charAt(i) == 'a' || str.charAt(i)== 'e' 
			||str.charAt(i) == 'i' || str.charAt(i) == 'o'
			||str.charAt(i) == 'u'|| str.charAt(i) == 'A' || str.charAt(i)== 'E' 
			||str.charAt(i) == 'I' || str.charAt(i) == 'O'
			||str.charAt(i) == 'U' 
			)
			{
			System.out.println("The Consant is " + str.charAt(i) + " "+ "At Index :" + i);
			}
			else
			{
				System.out.println("The Vowel is : " + str.charAt(i) + " At Index " + i);
			}
			
			Pattern p = Pattern.compile("[a/e/i/o/u]");
			Matcher m = p.matcher(str);
			while(m.find())
			{
				System.out.println(m.start()+ " " + m.group());
			}
		}
	}
}
