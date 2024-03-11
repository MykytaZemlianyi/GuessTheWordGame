package mykyta.zemlianyi.guess.the.word.game;

import java.util.Arrays;

public class Row {
	private char[] letters;

	public Row() {
	}

	public char[] getLetters() {
		return letters;
	}

	public void setLetters(char[] letters) {
		this.letters = letters;
	}

	public void setEmptyLetters() {
		char[] emptyLetters = new char[Constants.ROW_SIZE];
		Arrays.fill(emptyLetters, ' ');
		this.letters = emptyLetters;
	}

	public void printRow() {
		for (int i = 0; i < letters.length; i++) {
			char letter = letters[i];

			if (isCharacterMatchAtIndex(i)) {
				System.out.print(Colors.ANSI_GREEN + "[" + letter + "]" + Colors.ANSI_RESET);
			} else if (isCharacterContainedInSecretWord(i)) {
				System.out.print(Colors.ANSI_YELLOW + "[" + letter + "]" + Colors.ANSI_RESET);
			} else {
				System.out.print("[" + letter + "]");
			}
		}
		System.out.print(Colors.ANSI_RESET); // Explicitly reset color
		System.out.println(""); // Move to the next line

	}

	public static void printRowTable() {

		for (Row row : Main.rowTable) {
			row.printRow();
		}
	}

	public static void updateRowTable(Row row) {
		row.setLetters(Main.inputWord.getContentAsChar());
	}

	public boolean isCharacterMatchAtIndex(int index) {
		if (Main.secretWord.getContentAsChar() != null && index >= 0
				&& index < Main.secretWord.getContentAsChar().length) {

			return Main.secretWord.getContentAsChar()[index] == letters[index];
		}
		return false;
	}

	public boolean isCharacterContainedInSecretWord(int index) {
		if (Main.secretWord.getContentAsChar() != null && index >= 0
				&& index < Main.secretWord.getContentAsChar().length) {
			char ch = letters[index];
			for (char secretChar : Main.secretWord.getContentAsChar()) {
				if (secretChar == ch) {
					return true;
				}
			}
		}
		return false;
	}

}
