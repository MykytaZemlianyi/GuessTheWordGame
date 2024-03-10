package mykyta.zemlianyi.guess.the.word.game;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogicManager {

	public static String getWordFromInput(Scanner scanner) {
		return scanner.nextLine();
	}

	public static char[] inputWordToChar(String inputWord) {
		return inputWord.toCharArray();
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

	public static List<String> getWordListFromInput(Scanner scanner) {
		List<String> wordsList = new ArrayList<>();

		String input = scanner.nextLine();

		String[] wordsArray = input.split("\\s+");

		for (String word : wordsArray) {
			wordsList.add(word);
		}

		return wordsList;
	}

}