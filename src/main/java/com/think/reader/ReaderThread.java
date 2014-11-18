package com.think.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ReaderThread implements Runnable {

	private final File file;
	private BlockingQueue<Person> queue;

	public ReaderThread(final File file) {
		this.file = file;
		this.queue = new LinkedBlockingQueue<Person>();
	}
	
	public BlockingQueue<Person> getQueue() {
		return queue;
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
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
