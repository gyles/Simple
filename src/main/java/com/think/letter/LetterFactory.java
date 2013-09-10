package com.think.letter;

public class LetterFactory {
	
	public static Letter getLetter(Character character, int size)
	{
		Letter letter = null;
		if ("x".equalsIgnoreCase(Character.toString(character)))
		{
			letter = new LetterX(size);
		}
		return letter;
	}

}
