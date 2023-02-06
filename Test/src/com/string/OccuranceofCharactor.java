package com.string;

import java.util.HashMap;
import java.util.Map;

public class OccuranceofCharactor 
{
	public static void main(String[] args) 
	{
		String str = "google";
		int countOne =0 ;
		
		for(int i = 0 ; i< str.length();i++)
		{
			for(int j =i+1; j<str.length();j++)
			{
				if(str.charAt(i) == str.charAt(j))
				{
					System.out.println(str.charAt(i) + "  " + ++countOne);
					
				}
			}
		}
		
		String one = str.replaceAll("o", "");
		System.out.println(one.length());
		
		int total = str.length() - one.length();
		System.out.println(total);
		
		
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		for(int i = 0 ; i< str.length();i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				count = map.get(str.charAt(i));
				map.put(str.charAt(i),++count);
			}
			else
			{
				map.put(str.charAt(i),1);
			}
		}
		System.out.println(map);
		
	}
}
