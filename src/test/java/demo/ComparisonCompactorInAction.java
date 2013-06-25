package demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComparisonCompactorInAction {

	@Test
	public void testShortMessage() {
		assertEquals("abcde", "abc123");
	}

	@Test
	public void testLongMessage() {
		assertEquals("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvw123");
	}

}
