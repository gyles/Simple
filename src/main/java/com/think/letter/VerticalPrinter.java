package com.think.letter;

import java.util.List;

public class VerticalPrinter implements Printer {
	
	private List<Letter> letters;

	public List<Letter> getLetters() {
		return letters;
	}

	public void setLetters(List<Letter> letters) {
		this.letters = letters;
	}

	public void print() {
		for(Letter letter : letters)
		{
			for (String row : letter.getRows())
			{
				System.out.println(row);
			}
		}

	}

}
