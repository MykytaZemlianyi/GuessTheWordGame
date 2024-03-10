package mykyta.zemlianyi.guess.the.word.game;

import java.util.List;
import java.util.Scanner;

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
			DatabaseManager.addWordsToDatabase(LogicManager.getWordListFromInput(scanner));
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
