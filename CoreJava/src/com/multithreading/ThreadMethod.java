package com.multithreading;

public class ThreadMethod extends Thread
{
	@Override
	public void run() {
		
		super.run();
	}
	
	public static void main(String[] args) {
		Thread th = new Thread();
		Thread currentThread = Thread.currentThread();
		String name = currentThread.getName();
		System.out.println("Current Thread name is " + name);
		th.setName("Vedant");
		System.out.println("Name Changed To " + th.getName());
		System.out.println("The ID Of Thread "+ th.getId());
		System.out.println("The Priority of thread Of Thread "+ th.getPriority());
		System.out.println("The State of thread Of Thread "+ th.getState());
		System.out.println("The Thread Group of This this thread " +th.getThreadGroup().toString());
		
		th.run();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Program Ended");
	}
}
