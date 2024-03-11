package mykyta.zemlianyi.guess.the.word.game;

import java.util.List;

public class SpecialCommand {
	private String command;
	private String description;

	SpecialCommand(String command, String description) {
		this.command = command;
		this.description = description;
	}

	public String getCommand() {
		return command;
	}

	public String getDescription() {
		return description;
	}

	public static boolean isWordACommand(List<SpecialCommand> SpecialCommandList) {
		for (int i = 0; i < SpecialCommandList.size(); i++) {
			if (Main.inputWord.getContent().equals(SpecialCommandList.get(i).getCommand())) {
				return true;
			}
		}
		return false;
	}

	public static void runCommand(String command) {

		switch (command) {
		case "-help":
			printCommandList();
			break;
		case "-clear":
			DatabaseManager.clearDatabase();
			System.out.println("Database cleared.");
			break;
		case "-add":

			DatabaseManager
					.addWordsToDatabase(DatabaseManager.filterWords(LogicManager.getWordListFromInput(Main.scanner)));
			break;

		default:
			break;
		}
	}

	public static void printCommandList() {
		for (int i = 0; i < Main.SpecialCommandList.size(); i++) {
			System.out.println(Main.SpecialCommandList.get(i).getCommand() + "\t"
					+ Main.SpecialCommandList.get(i).getDescription());
		}
	}
}
