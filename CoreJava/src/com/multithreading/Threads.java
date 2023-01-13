package com.multithreading;

class Mythread extends Thread {
	@Override
	public void run() {

		//System.out.println("Run Method Starts");
		for (int i = 0; i < 4; i++) {
			System.out.println("MyThread Starts" + i);
		
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	}
}

class RunThread implements Runnable {

	@Override
	public void run() {
		//System.out.println("Run Method Starts");
		for (int i = 0; i < 4; i++) {
			System.out.println("RunThread Starts" + i);
		
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	}
}

public class Threads {
	public static void main(String[] args) {

		//RunThread
		RunThread run = new RunThread();
		Thread th = new Thread(run);
		
		//MyThread
		Mythread thread = new Mythread();
		System.out.println("");
		thread.run();
		th.run();

	}
}
