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

	public static List<Row> rowTable = new ArrayList<>();

	private static List<SpecialCommand> SpecialCommandList = new ArrayList<>();

	public static Word secretWord;

	public static String inputWord;
	public static char[] inputWordAsChar;

	public static void main(String[] args) {
		boolean GameWon = false;

		secretWord = new Word();
		secretWord.setContent(DatabaseManager.getWord());

		row1.setEmptyLetters();
		row2.setEmptyLetters();
		row3.setEmptyLetters();
		row4.setEmptyLetters();
		row5.setEmptyLetters();
		row6.setEmptyLetters();

		SpecialCommandList.add(Constants.COMMAND1);
		SpecialCommandList.add(Constants.COMMAND2);
		SpecialCommandList.add(Constants.COMMAND3);

		rowTable.add(row1);
		rowTable.add(row2);
		rowTable.add(row3);
		rowTable.add(row4);
		rowTable.add(row5);
		rowTable.add(row6);

		for (int i = 0; i < Constants.TRIES; i++) {

			System.out.println("Secret Word - " + secretWord.getContent()); // REMOVE

			Row.printRowTable();
			inputWord = LogicManager.getWordFromInput(scanner);
			inputWordAsChar = LogicManager.inputWordToChar(inputWord);

			if (SpecialCommand.isWordACommand(inputWord, SpecialCommandList)) {
				LogicManager.clearConsole();
				SpecialCommand.runCommand(inputWord, SpecialCommandList);
				i--;
				continue;
			} else {

				if (inputWord.length() == 5) {
					Row.updateRowTable(rowTable.get(i));
					LogicManager.clearConsole();
				} else
					i--;
				LogicManager.clearConsole();
			}

			if (Arrays.equals(rowTable.get(i).getLetters(), secretWord.getContentAsChar())) {
				GameWon = true;
				System.out.println("You WON!");
				break;
			}
		}

		if (GameWon == false) {
			System.out.println("Game Lost :(");
			System.out.println("Secret word: " + secretWord.getContent());
		}
		Row.printRowTable();
	}

}
