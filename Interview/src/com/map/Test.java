package com.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {

//1)HashMap ::
		//Unorder
		//Ds -> HashTable
		//Duplicate key Will Not Allowed but there will be no 
		//compile time error
		//null key is possible only once because key should be unique 
		//and null values is possible
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Vedant");
		map.put(3, "Vedant");
		map.put(0, null);
		map.put(2, null);
		map.put(1, "Vednt"); 
		//as vedant and vednt have same key then 
		//in that case the most recent value of key will print
		
		//First Way To Print The Key And Value
		//System.out.println(map.entrySet());
		
		//SecondWay
		Set<Integer> set = map.keySet();
		for(int i : set)
		{
			System.out.println(i);
			System.out.println(map.get(i));
		}
		
		//Third Way
		Set<Integer> sets  = map.keySet();
		Iterator<Integer> itr = sets.iterator();
		while(itr.hasNext())
		{
			int i = itr.next();
			System.out.println(i);
			System.out.println(map.get(i));
		}
		
		//ENtry Set
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
		while(iterator.hasNext())
		{
			 Map.Entry<Integer, String> entry = iterator.next();
			 System.out.println(entry.getKey() + " " + entry.getValue());			
		}
		

		
//2)LinkedHashmap ::
		//DS -> LinkedList + HashTable
		//insertion order is preserved
		//Other things are same as the Hashmap
		
		Map<Integer, String> lMap = new LinkedHashMap<Integer, String>();
		lMap.put(1, "Akshay");
		lMap.put(3, "Hrushikesh");
		lMap.put(2, "Vedant");
		//System.out.println(lMap);
		
//3)TreeMap::
	//1) it impelements the sortedmap which is the sub interface of navigable map
	//2)Sorted manner(Ascending)
	//3)unordered
	
		Map<Integer, String> tMap = new TreeMap<Integer, String>();
		tMap.put(1,"Vedant");
		tMap.put(0,"Akki");
		tMap.put(2,"Ved");
		tMap.put(2,null);		
		//System.out.println(tMap);
		
//4)HashTable ::
	//1)it implements map interface and extends dictonary classe
	//2)null key and null value is not possible if we do it will
	//show compile time error
	//3)Unordered
	
	Map<Integer, String> hashtable = new Hashtable<Integer, String>();
	hashtable.put(1, "Vedant");
	hashtable.put(2, "Ved");
	//hashtable.put(null, "Vedant");
	//System.out.println(hashtable);

	}
}
