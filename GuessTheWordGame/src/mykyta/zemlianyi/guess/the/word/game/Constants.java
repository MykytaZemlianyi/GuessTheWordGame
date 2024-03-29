package mykyta.zemlianyi.guess.the.word.game;

public class Constants {
	public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "1234";
	public static final String DB_NAME = "\"WordList\".wordlist";

	public static final int ROW_SIZE = 5;

	public static final SpecialCommand COMMAND1 = new SpecialCommand("-help", "");
	public static final SpecialCommand COMMAND2 = new SpecialCommand("-clear", "Clears Database");
	public static final SpecialCommand COMMAND3 = new SpecialCommand("-add",
			"add words from input separated with spaces into database");

	public static final int TRIES = 6;

}
