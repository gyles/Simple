package com.think.letter;

import java.io.IOException;
import java.util.List;

public interface Printer {
	
	void print() throws IOException;
	
	void setLetters(List<Letter> letters);

}
