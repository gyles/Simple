package com.think.letter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Client {
	
	static List<Character> getCharacters(BufferedReader reader) throws IOException
	{
		List<Character> characters = new ArrayList<Character>();
		System.out.print("Enter a letter sequence (must be x, y or z letters only): ");
		String input = reader.readLine();
		while (!isSupported(input)) {
			System.out.print("Must be x, y or z letters only, or type 'quit': ");
			input = reader.readLine();
			if (isQuit(input)) {
				break;
			}
		}
		
		if (isSupported(input))	{
			characters = convertToCharacterList(input);
		}
		
		return characters;
	}
	
	static int getCharacterSize(BufferedReader reader) throws IOException
	{
		int characterSize = 0;
		System.out.print("Enter a character size (must be an odd number): ");
		String input = reader.readLine();
		while (!isOddNumber(input)) {
			System.out.print("Must be an odd number, or type 'quit': ");
			input = reader.readLine();
			if (isQuit(input)) {
				break;
			}
		}
		
		if(isOddNumber(input)) {
			characterSize = Integer.parseInt(input);
		}
		return characterSize;
	}
	
	static int getPrintFormat(BufferedReader reader) throws IOException
	{
		System.out.print("Choose a print format (must be 0 or 1): ");
		String input = reader.readLine();
		return 0;
	}
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Letter> letters = buildLetters(reader);
		if (letters.size() > 0)
		{
			Printer printer = buildPrinter(reader);
			printer.setLetters(letters);
			printer.print();
		}
		
		reader.close();
	}

	private static List<Letter> buildLetters(BufferedReader reader) throws IOException {
		List<Letter> letters = new ArrayList<Letter>();
		List<Character> characters = getCharacters(reader);
		
		if(characters.size() > 0)
		{
			int characterSize = getCharacterSize(reader);
			if (characterSize > 0)
			{
				for (Character character : characters)
				{
					Letter letter = LetterFactory.getLetter(character, characterSize);
					letters.add(letter);
				}
			}
		}
		
		return letters;
	}
	
	private static Printer buildPrinter(BufferedReader reader) throws IOException
	{
		Printer printer = null;
		int printFormat = getPrintFormat(reader);
		if (printFormat == 0)
		{
			printer = new VerticalPrinter();
		}
		return printer;
	}
	
	private static boolean isSupported(String characterSequence)
	{
		boolean isSupported = false;
		
		if (characterSequence != null && characterSequence.matches("[xyz]+"))
		{
			isSupported = true;
		}
		return isSupported;
	}
	
	private static boolean isOddNumber(String characterSequence)
	{
		boolean isOddNumber = false;
		
		if (characterSequence != null && characterSequence.matches("[\\d]+"))
		{
			Integer integer = Integer.parseInt(characterSequence);
			if (integer % 2 != 0)
			{
				isOddNumber = true;
			}
		}
		return isOddNumber;
	}
	
	private static boolean isQuit(String characterSequence)
	{
		boolean isQuit = false;
		
		if (characterSequence != null && "quit".equalsIgnoreCase(characterSequence))
		{
			isQuit = true;
		}
		return isQuit;
	}
	
	private static List<Character> convertToCharacterList(String characterSequence)
	{
		List<Character> characters = new ArrayList<Character>();
		for (int index = 0; index < characterSequence.length(); index++)
		{
			characters.add(characterSequence.charAt(index));
		}
		return characters;
	}
	
}
