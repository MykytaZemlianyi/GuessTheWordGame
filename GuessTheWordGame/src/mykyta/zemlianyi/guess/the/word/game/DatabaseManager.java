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

	public DatabaseManager() {

	}

	public static Connection getConnectionToDb() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(Constants.JDBC_URL, Constants.USERNAME, Constants.PASSWORD);
	}

	public static String getWord() {
		int maxAttempts = 2;

		for (int attempt = 0; attempt < maxAttempts; attempt++) {
			String result = tryGetWord();

			if (result != null) {
				markWordAsUsed(result);
				return result;
			}
		}

		return null;
	}

	private static String tryGetWord() {
		try (Connection connection = getConnectionToDb()) {
			String query = "SELECT word FROM " + Constants.DB_NAME + " WHERE is_used = false ORDER BY random() LIMIT 1";
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				return resultSet.getString("word");
			} else {
				markAllWordsAsNotUsed();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void addWordsToDatabase(List<String> words) {
		try (Connection connection = getConnectionToDb()) {
			String query = "INSERT INTO " + Constants.DB_NAME + " (word, is_used) VALUES (?, false)";

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

	public static void clearDatabase() {
		try (Connection connection = getConnectionToDb()) {
			try (Statement statement = connection.createStatement()) {
				String clearQuery = "DELETE FROM " + Constants.DB_NAME;
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
						.prepareStatement("UPDATE " + Constants.DB_NAME + " SET is_used = true WHERE word = ?")) {

			preparedStatement.setString(1, wordToUpdate);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void markAllWordsAsNotUsed() {
		try (Connection connection = getConnectionToDb();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE " + Constants.DB_NAME + " SET is_used = false")) {

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
