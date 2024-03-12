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

	public static boolean isWordACommand(List<SpecialCommand> SpecialCommandList, Word inputWord) {
		for (int i = 0; i < SpecialCommandList.size(); i++) {
			if (inputWord.getContent().equals(SpecialCommandList.get(i).getCommand())) {
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

	public static void printCommandList(List<SpecialCommand> SpecialCommandList) {
		for (int i = 0; i < SpecialCommandList.size(); i++) {
			System.out.println(
					SpecialCommandList.get(i).getCommand() + "\t" + SpecialCommandList.get(i).getDescription());
		}
	}
}
