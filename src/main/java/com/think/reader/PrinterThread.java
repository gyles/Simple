package com.think.reader;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class PrinterThread implements Runnable {
	
	private final BlockingQueue<Person> queue;
	
	public PrinterThread(BlockingQueue<Person> queue)
	{
		this.queue = queue;
	}

	public void run() {
		try {
			Person p = null;
			while((p = queue.poll(60, TimeUnit.SECONDS)) != null)
			{
				if (p.equals(Poison.getInstance())) {
					queue.add(Poison.getInstance());
					System.out.println("Poison reached ending");
					break;
				}
				System.out.println(p.getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
