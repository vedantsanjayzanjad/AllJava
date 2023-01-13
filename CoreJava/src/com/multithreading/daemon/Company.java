package com.multithreading.daemon;

public class Company 
{
	int n;
	boolean b = false;
	synchronized public void getProduce(int n) throws InterruptedException
	{
		if(b)
		{
			wait();
		}
		this.n = n;
		System.out.println("Produced " + n);
		b = true;
		notify();
	}
	
	synchronized public int consumer_item() throws InterruptedException
	{
		if(!b)
		{
			wait();
		}
		
		System.out.println("Consumed " + this.n);
		b = false;
		notify();
		return this.n;
		
	}
}
