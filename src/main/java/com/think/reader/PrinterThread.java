package com.think.reader;

import java.util.concurrent.BlockingQueue;

public class PrinterThread implements Runnable {
	
	private final BlockingQueue<Person> queue;
	
	public PrinterThread(BlockingQueue<Person> queue)
	{
		this.queue = queue;
	}

	public void run() {
		Person p = null;
		while((p = queue.poll()) != null)
		{
			System.out.println(p.getName());
		}
	}

}
