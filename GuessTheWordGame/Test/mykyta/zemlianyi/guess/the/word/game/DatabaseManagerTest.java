package mykyta.zemlianyi.guess.the.word.game;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class DatabaseManagerTest {

	@Test
	public void testAddWordsToDatabase() throws SQLException {
		// Arrange
		DatabaseManager databaseManager = new DatabaseManager();

		// Act
		databaseManager.addWordsToDatabase(Arrays.asList("word1", "word2"));

		// Assert
		// Verify that the words are actually in the database
		try (Connection connection = databaseManager.getConnectionToDb();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM \"WordList\".wordlist")) {

			ResultSet resultSet = preparedStatement.executeQuery();
			assertTrue(resultSet.next());
			assertEquals("word1", resultSet.getString("word"));
			assertTrue(resultSet.next());
			assertEquals("word2", resultSet.getString("word"));
		}
	}

	@Test
	public void testGetWordsFromInput() {
		String input = "apple banana cherry";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		Scanner scanner = new Scanner(inputStream);

		List<String> result = DatabaseManager.getWordListFromInput(scanner);

		assertEquals(Arrays.asList("apple", "banana", "cherry"), result);
	}

	@Test
	public void testFilterFiveCharacterWords() {
		List<String> inputWords = Arrays.asList("apple", "banana", "cherry", "table");

		List<String> result = DatabaseManager.filterWords(inputWords);

		assertEquals(Arrays.asList("apple", "table"), result);
	}

}
