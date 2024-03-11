package mykyta.zemlianyi.guess.the.word.game;

public class Word {
	private String content;
	private char[] contentAsChar;

	public String getContent() {
		return content;
	}

	public char[] getContentAsChar() {
		return contentAsChar;
	}

	public void setContent(String word) {
		this.content = word;
		this.contentAsChar = word.toCharArray();
	}
}