package com.think.reader;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	public static void main (String[] args)
	{
		BlockingQueue<Person> queue = new LinkedBlockingQueue<Person>();
		AtomicInteger counter = new AtomicInteger(0);
		File source = new File("C:\\Users\\Gyles\\Documents\\Development\\Temp");
		ExecutorService reader = Executors.newFixedThreadPool(2);
		File[] files = source.listFiles();
		for (File file : files) {
			ReaderThread thread = new ReaderThread(file);
			thread.setQueue(queue);
			thread.setCounter(counter);
			thread.setNumberOfFiles(files.length);
			reader.execute(thread);
		}
		reader.shutdown();
		ExecutorService consumer = Executors.newFixedThreadPool(2);
		consumer.execute(new PrinterThread(queue));
		consumer.execute(new PrinterThread(queue));
		consumer.shutdown();
	}
}
