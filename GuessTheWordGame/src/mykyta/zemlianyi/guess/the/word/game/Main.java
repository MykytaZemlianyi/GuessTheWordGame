package mykyta.zemlianyi.guess.the.word.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static String secretWord = "mango";
	private static char[] secretWordAsChar = secretWord.toCharArray();

	private static String inputWord = "track";
	private static char[] inputWordAsChar = inputWord.toCharArray();

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

	private static int triesLeft = 6;

	public static void main(String[] args) {
		rowTable.add(row1);
		rowTable.add(row2);
		rowTable.add(row3);
		rowTable.add(row4);
		rowTable.add(row5);
		rowTable.add(row6);

		for (int i = 0; i <= triesLeft; i++) {
			
			printRowTable(rowTable);
			printKeyboard();
			if (i!=triesLeft) {	
			LogicManager.updateRowTable(LogicManager.getWordFromInput(scanner), rowTable.get(i));
			}
			
		}
	}

	public static void printRowTable(List<Row> rowTable) {
		for (Row row : rowTable) {
			row.printRow();
		}
	}

	public static void printKeyboard() {
		char[][] keyboardLayout = { { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P' },
				{ 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L' }, { 'Z', 'X', 'C', 'V', 'B', 'N', 'M' } };

		for (char[] row : keyboardLayout) {
			for (char key : row) {
				System.out.print(key + " ");
			}
			System.out.println();
		}
	}

}
