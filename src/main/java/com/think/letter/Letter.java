package com.think.letter;

import java.util.List;

public interface Letter {
	
	final char PRINT_CHAR = '*';
	final char FILL_CHAR = ' ';
	
	List<String> getRows();

}
