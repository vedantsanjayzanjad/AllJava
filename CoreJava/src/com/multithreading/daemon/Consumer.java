package com.multithreading.daemon;

public class Consumer extends Thread {

	Company c;
	Consumer(Company c)
	{
		this.c = c;
	}
	
	@Override
	public void run() {
		int i = 1;
		while(true)
		{
			try {
				this.c.getProduce(i);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
	}
}
