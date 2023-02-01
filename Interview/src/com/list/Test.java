package com.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		//collection ??
//		sorting a list
//		Collections.sort(list);
//		System.out.println(list);
//		Collections.sort(list,Collections.reverseOrder());
//		System.out.println(list);
		
		//when we want represent the group of object as a single entity then
		//it is called as the collection
		
		
//1)ArrayList
		//best case when we want to perform the frequent retrival operation
		//and when null insertion is possible and duplicate values are allowed
		//ds -> Growable in nature
		//index based
		//java.util
		//insertion order is preserved
		
//		List<Integer>list = new ArrayList<Integer>();
//		list.add(22);
//		list.add(12);
//		list.add(24);
		 
		
		
		
		
//2)LINKEDLIST::::
		//Best case when we want to perform frequntly insertion and deletion operation
		//and when null insertion is possible and duplicate values are allowed
		//ds -> doubly Linked
		//node based
		//java.util
		//insertion order is preserved
		
//		List<Integer>list = new LinkedList<Integer>();
//		list.add(22);
//		list.add(12);
//		list.add(24);
//		System.out.println(list);
		
//3)Vector ::::
		//vector is legacy class
		//and same as the arraylist
		//but the main differnce like it is synchronized
		//that is why is tnread safe and
		//its performance is low
		
//		List list = new Vector();
//		list.add(88);
//		list.add(82);
//		System.out.println(list);
		
		
//4)Stack ::::
		//stack is the child class of the vector
		//stack follows last in first out
		//it have some method
		//push ::: Insert the elemenets
		//pop  ::: it will remove top most elements of the stack
		//peak ::: it will only return the top most elements of the stack
		//search ::: it will search the elements on the particular index
		
		
//		Stack list = new Stack();
//		list.push(22);
//		list.push(23);
//		list.push(24);
//		list.push(25);
////		System.out.println(list.pop());
////		System.out.println(list.peek());
//		System.out.println(list.search(22));
		
	}
}
