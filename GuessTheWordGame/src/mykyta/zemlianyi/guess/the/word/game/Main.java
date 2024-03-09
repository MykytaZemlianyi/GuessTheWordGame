package mykyta.zemlianyi.guess.the.word.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	private static char[] row1WordAsChar = new char[5];
	private static Row row1 = new Row(row1WordAsChar);

	private static char[] row2WordAsChar = new char[5];
	private static Row row2 = new Row(row2WordAsChar);

	private static char[] row3WordAsChar = new char[5];
	private static Row row3 = new Row(row3WordAsChar);

	private static char[] row4WordAsChar = new char[5];
	private static Row row4 = new Row(row4WordAsChar);

	private static char[] row5WordAsChar = new char[5];
	private static Row row5 = new Row(row5WordAsChar);

	private static char[] row6WordAsChar = new char[5];
	private static Row row6 = new Row(row6WordAsChar);

	private static List<Row> rowTable = new ArrayList<>();

	private static int tries = 6;

	public static void main(String[] args) {
		String secretWord = DatabaseManager.getWord();
		char[] secretWordAsChar = secretWord.toCharArray();

		String inputWord;
		boolean GameWon = false;

		rowTable.add(row1);
		rowTable.add(row2);
		rowTable.add(row3);
		rowTable.add(row4);
		rowTable.add(row5);
		rowTable.add(row6);

		for (int i = 0; i < tries; i++) {
			Row.printRowTable(rowTable, secretWordAsChar);
			inputWord = LogicManager.getWordFromInput(scanner);

			if (inputWord.length() == 5) {
				LogicManager.updateRowTable(inputWord, rowTable.get(i));
			} else {
				System.out.println("Input word must be 5 characters long.");
				i--;
			}

			LogicManager.clearConsole();

			if (Arrays.equals(rowTable.get(i).getLetters(), secretWordAsChar)) {
				GameWon = true;
				System.out.println("You WON!");
				break;
			}
		}

		if (GameWon == false) {
			System.out.println("Game Lost :( ");
		}
		Row.printRowTable(rowTable,secretWordAsChar);
	}

}
