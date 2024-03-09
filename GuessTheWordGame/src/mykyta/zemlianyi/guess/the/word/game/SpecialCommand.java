package mykyta.zemlianyi.guess.the.word.game;

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
}
