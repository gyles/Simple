package com.think.letter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilePrinter implements Printer {

	private List<Letter> letters;

	public List<Letter> getLetters() {
		return letters;
	}

	public void setLetters(List<Letter> letters) {
		this.letters = letters;
	}
	
	public void print() throws IOException {
		File directory = new File("D:\\Git Repositories\\Simple");
		File file = new File(directory, "printer.out");
		if (!directory.exists())
		{
			directory.mkdirs();
		}
		if (!file.exists())
		{
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(file);
		for(Letter letter : letters)
		{
			for (String row : letter.getRows())
			{
				writer.write(row);
				writer.write('\n');
			}
		}
		writer.close();

	}

}
