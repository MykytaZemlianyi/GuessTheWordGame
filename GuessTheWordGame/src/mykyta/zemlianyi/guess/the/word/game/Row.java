package mykyta.zemlianyi.guess.the.word.game;

import java.util.List;

public class Row {
	private char[] letters;

	public Row(char[] letters) {
		this.letters = letters;
	}

	public char[] getLetters() {
		return letters;
	}

	public void setLetters(char[] letters) {
		this.letters = letters;
	}

	public void printRow() {
		for (char letter : letters) {
			System.out.print("[" + letter + "]");
		}
		System.out.println("");
	}

	public static void printRowTable(List<Row> rowTable) {
		for (Row row : rowTable) {
			row.printRow();
		}
	}
}
