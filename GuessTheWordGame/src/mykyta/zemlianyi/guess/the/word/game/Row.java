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

	public void printRow(char[] secretWordAsChar) {
		for (int i = 0; i < letters.length; i++) {
			char letter = letters[i];

			if (isCharacterMatchAtIndex(letters, secretWordAsChar, i)) {
				System.out.print(Colors.ANSI_GREEN + "[" + letter + "]" + Colors.ANSI_RESET);
			} else if (isCharacterContainedInSecretWord(letters, secretWordAsChar, i)) {
				System.out.print(Colors.ANSI_YELLOW + "[" + letter + "]" + Colors.ANSI_RESET);
			} else {
				System.out.print("[" + letter + "]");
			}
		}
		System.out.println("");
	}

	public static void printRowTable(List<Row> rowTable, char[] secretWordAsChar) {
		for (Row row : rowTable) {
			row.printRow(secretWordAsChar);
		}
	}

	public static void updateRowTable(String word, Row row) {
		row.setLetters(word.toCharArray());
	}

	public static boolean isCharacterMatchAtIndex(char[] inputWord, char[] secretWord, int index) {
		return inputWord[index] == secretWord[index];
	}

	public static boolean isCharacterContainedInSecretWord(char[] inputWord, char[] secretWord, int index) {
		char ch = inputWord[index];
		for (char secretChar : secretWord) {
			if (secretChar == ch) {
				return true;
			}
		}
		return false;
	}

}
