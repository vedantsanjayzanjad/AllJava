package practice;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java8Iterate {	
	public static void main(String[] args) {
		//JAVA 8 Itereator
		List<Integer> list = new ArrayList<>();
		list = Arrays.asList(12,13,132,45,5223,2,34);
		
		list.stream().forEach(e->System.out.println(e));
		
		//java8 map iterating
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("Vedant", 123);
		map.put("Akshay", 123);
		map.put("Jaydip", 123);
		map.forEach((k, v) -> System.out.println((k + " : " + v)));
		
		
		//java8 map iterating
		map.keySet().forEach(i->System.out.println(i + " : " + map.get(i)));
		
		//java8 map iterating
		map.entrySet().stream().forEach(v->System.out.println(v.getKey() + " : " + v.getValue()));
	}
}
