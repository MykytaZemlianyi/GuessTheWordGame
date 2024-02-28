package mykyta.zemlianyi.guess.the.word.game;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogicManager {

	public static String getWordFromInput(Scanner scanner) {
		return scanner.nextLine();
	}

	public static void clearConsole() {
		try {
			final Console console = System.console();

			if (console != null) {
				console.writer().print("\033[H\033[2J");
				console.flush();
			} else {
				for (int i = 0; i < 100; ++i)
					System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void updateRowTable(String word, Row row) {
		row.setLetters(word.toCharArray());
	}
}
