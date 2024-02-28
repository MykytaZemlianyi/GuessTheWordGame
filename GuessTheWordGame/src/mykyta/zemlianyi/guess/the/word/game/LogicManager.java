package mykyta.zemlianyi.guess.the.word.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogicManager {
	public static final String CLEAR_CONSOLE = "\u001B[2J\u001B[H";

	
	public static String getWordFromInput(Scanner scanner) {
		return scanner.nextLine();
	}
	
	public static void clearConsole() {
		System.out.print(CLEAR_CONSOLE);
		System.out.flush();
	}

	public void GameWon() {
		clearConsole();
		System.out.println("You WON!");
	}

	public void GameLost() {
		clearConsole();
		System.out.println("You Lost");
	}
	public static void updateRowTable(String word, Row row) {
		row.setLetters(word.toCharArray());
	}
}
