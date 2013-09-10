package com.think.letter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterX implements Letter {
	
	private int size;
	
	LetterX(int size)
	{
		this.size = size;
	}

	public List<String> getRows() {
		List<String> rows = new ArrayList<String>();
		for(int rowNumber=0 ; rowNumber < size; rowNumber++)
		{
			String row = buildRow(rowNumber);
			rows.add(row);
		}
		return rows;
	}
	
	private String buildRow(int rowNumber)
	{
		StringBuilder sb = new StringBuilder(buildBlankRow());
		int firstDiagonalIndex = rowNumber;
		int secondDiagonalIndex = size - rowNumber;
		sb.replace(firstDiagonalIndex, firstDiagonalIndex+1, Character.toString(PRINT_CHAR));
		sb.replace(secondDiagonalIndex-1, secondDiagonalIndex, Character.toString(PRINT_CHAR));
		return sb.toString();
	}
	
	private String buildBlankRow()
	{
		char[] chars = new char[size];
		Arrays.fill(new char[size], FILL_CHAR);
		StringBuilder sb = new StringBuilder();
		sb.append(chars);
		
		return sb.toString();
	}

}
