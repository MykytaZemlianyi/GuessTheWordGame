package mykyta.zemlianyi.guess.the.word.game;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.ResultSet;

public class DatabaseManager {

	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "1234";
	private static final String DB_NAME = "\"WordList\".wordlist";

	public DatabaseManager() {

	}

	public static Connection getConnectionToDb() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	}

	public static String getWord() {
		String result = null;

		try (Connection connection = getConnectionToDb()) {
			String query = "SELECT word FROM " + DB_NAME + " WHERE is_used = false ORDER BY random() LIMIT 1";
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				result = resultSet.getString("word");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		markWordAsUsed(result);
		return result;
	}

	public static void addWordsToDatabase(List<String> words) {
		try (Connection connection = getConnectionToDb()) {
			String query = "INSERT INTO " + DB_NAME + " (word, is_used) VALUES (?, false)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				for (String word : words) {
					preparedStatement.setString(1, word);
					preparedStatement.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getWordsFromInput(Scanner scanner) {
		List<String> wordsList = new ArrayList<>();

		String input = scanner.nextLine();

		String[] wordsArray = input.split("\\s+");

		for (String word : wordsArray) {
			wordsList.add(word);
		}

		return wordsList;
	}

	public static void clearDatabase() {
		try (Connection connection = getConnectionToDb()) {
			try (Statement statement = connection.createStatement()) {
				String clearQuery = "DELETE FROM \"WordList\".wordlist";
				statement.executeUpdate(clearQuery);
				System.out.println("Database cleared successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void markWordAsUsed(String wordToUpdate) {
		try (Connection connection = getConnectionToDb();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE " + DB_NAME + " SET is_used = true WHERE word = ?")) {

			preparedStatement.setString(1, wordToUpdate);
			
			preparedStatement.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> filterWords(List<String> inputWords) {
		List<String> fiveCharacterWords = new ArrayList<>();

		for (String word : inputWords) {
			if (word.length() == 5 && fiveCharacterWords.contains(word) == false) {
				fiveCharacterWords.add(word);
			}
		}

		return fiveCharacterWords;
	}

}
