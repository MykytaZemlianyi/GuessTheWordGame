package mykyta.zemlianyi.guess.the.word.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RowTest {

	@Test
	public void testGetLeeters() {
		
		Row row = new Row("apple".toCharArray());
		
		assertArrayEquals("apple".toCharArray(), row.getLetters());
	}

}
