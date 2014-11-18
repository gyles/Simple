package com.think.reader;

public class Poison extends Person {
	
	private static final Poison INSTANCE = new Poison();

	public static Poison getInstance() {
		return INSTANCE;
	}

}
