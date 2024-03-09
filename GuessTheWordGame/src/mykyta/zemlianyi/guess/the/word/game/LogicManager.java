package mykyta.zemlianyi.guess.the.word.game;

import java.io.Console;
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

	public static boolean isWordACommand(String inputWord, List<SpecialCommand> SpecialCommandList) {
		for (int i = 0; i < SpecialCommandList.size(); i++) {
			if (inputWord.equals(SpecialCommandList.get(i).getCommand())) {
				return true;
			}
		}
		return false;
	}

	public static void runCommand(String command, List<SpecialCommand> SpecialCommandList) {

		switch (command) {
		case "-help":
			printCommandList(SpecialCommandList);
			break;
		case "-clear":
			DatabaseManager.clearDatabase();
			break;
		case "-add":
			Scanner scanner = new Scanner(System.in);
			DatabaseManager.addWordsToDatabase(DatabaseManager.getWordListFromInput(scanner));
			break;

		default:
			break;
		}
	}

	public static void printCommandList(List<SpecialCommand> SpecialCommandList) {
		for (int i = 0; i < SpecialCommandList.size(); i++) {
			System.out.println(
					SpecialCommandList.get(i).getCommand() + "\t" + SpecialCommandList.get(i).getDescription());
		}
	}

}