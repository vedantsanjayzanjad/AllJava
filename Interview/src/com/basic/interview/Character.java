//package com.basic.interview;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Character 
//{
//	public static void main(String[] args) {
//		String str = "google";
//		Integer count;
//		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//		
//		for(int i = 0; i < str.length();i++)
//		{
//			if(map.containsKey(str.charAt(i)))
//			{
//				
//				 count = map.get(str.charAt(i));
//				map.put(str.charAt(i), ++count);
//			}
//			
//			else
//			{
//				map.put(str.charAt(i), 1);
//			}
//			
//			System.out.println(count);
//		}
//	}
//}
