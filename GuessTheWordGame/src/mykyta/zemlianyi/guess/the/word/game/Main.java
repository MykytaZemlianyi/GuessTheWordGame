package mykyta.zemlianyi.guess.the.word.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	private static Row row1 = new Row();
	private static Row row2 = new Row();
	private static Row row3 = new Row();
	private static Row row4 = new Row();
	private static Row row5 = new Row();
	private static Row row6 = new Row();

	private static List<Row> rowTable = new ArrayList<>();

	private static List<SpecialCommand> SpecialCommandList = new ArrayList<>();
	private static SpecialCommand command1 = new SpecialCommand("-help", "");

	private static SpecialCommand command2 = new SpecialCommand("-clear", "Clears Database");

	private static SpecialCommand command3 = new SpecialCommand("-add",
			"add words from input separated with spaces into database");

	private static int tries = 6;

	public static void main(String[] args) {

		row1.setEmptyLetters();
		row2.setEmptyLetters();
		row3.setEmptyLetters();
		row4.setEmptyLetters();
		row5.setEmptyLetters();
		row6.setEmptyLetters();

		String secretWord = DatabaseManager.getWord();
		char[] secretWordAsChar = secretWord.toCharArray();

		String inputWord;
		char[] inputWordAsChar;

		boolean GameWon = false;

		SpecialCommandList.add(command1);
		SpecialCommandList.add(command2);
		SpecialCommandList.add(command3);

		rowTable.add(row1);
		rowTable.add(row2);
		rowTable.add(row3);
		rowTable.add(row4);
		rowTable.add(row5);
		rowTable.add(row6);

		for (int i = 0; i < tries; i++) {
			Row.printRowTable(rowTable, secretWordAsChar);
			inputWord = LogicManager.getWordFromInput(scanner);
			inputWordAsChar = LogicManager.inputWordToChar(inputWord);

			if (SpecialCommand.isWordACommand(inputWord, SpecialCommandList)) {
				SpecialCommand.runCommand(inputWord, SpecialCommandList);
				i--;
				continue;
			} else {

				if (inputWord.length() == 5) {
					Row.updateRowTable(inputWord, rowTable.get(i));
					LogicManager.clearConsole();
				} else
					i--;
			}

			if (Arrays.equals(rowTable.get(i).getLetters(), secretWordAsChar)) {
				GameWon = true;
				System.out.println("You WON!");
				break;
			}

		}

		if (GameWon == false) {
			System.out.println("Game Lost :(");
			System.out.println("Secret word: " + secretWord);
		}
		Row.printRowTable(rowTable, secretWordAsChar);
	}

}
