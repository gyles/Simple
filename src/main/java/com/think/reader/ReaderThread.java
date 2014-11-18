package com.think.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ReaderThread implements Runnable {

	private final File file;
	private BlockingQueue<Person> queue;
	private AtomicInteger counter;
	private Integer numberOfFiles;

	public ReaderThread(final File file) {
		this.file = file;
		this.queue = new LinkedBlockingQueue<Person>();
		this.counter = new AtomicInteger(0);
	}
	
	public BlockingQueue<Person> getQueue() {
		return queue;
	}

	public void setCounter(AtomicInteger counter) {
		this.counter = counter;
	}
	
	public void setNumberOfFiles(Integer numberOfFiles) {
		this.numberOfFiles = numberOfFiles;
	}

	public void setQueue(BlockingQueue<Person> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			if (file.isFile()) {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = null;
				while ((line = reader.readLine()) != null) {
					Person p = new Person();
					p.setName(line);
					this.queue.add(p);
				}
				reader.close();
				if (this.counter.incrementAndGet() == numberOfFiles) {
					this.queue.add(Poison.getInstance());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
