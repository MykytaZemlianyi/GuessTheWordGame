package mykyta.zemlianyi.guess.the.word.game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class LogicManagerTest {

	@Test
	public void isWordACommand() {
		String inputWord = "-help";
		List<SpecialCommand> SpecialCommandList = new ArrayList();

		SpecialCommand command1 = new SpecialCommand("-help", "");

		SpecialCommand command2 = new SpecialCommand("-clear", "Clears Database");

		SpecialCommand command3 = new SpecialCommand("-add",
				"add words from input separated with spaces into database");
		SpecialCommandList.add(command1);
		SpecialCommandList.add(command2);
		SpecialCommandList.add(command3);

		boolean result = LogicManager.isWordACommand(inputWord, SpecialCommandList);
		assertEquals(true, result);
	}

	@Test
	public void testGetWordsFromInput() {
		String input = "apple banana cherry";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		Scanner scanner = new Scanner(inputStream);

		List<String> result = LogicManager.getWordListFromInput(scanner);

		assertEquals(Arrays.asList("apple", "banana", "cherry"), result);
	}
}
