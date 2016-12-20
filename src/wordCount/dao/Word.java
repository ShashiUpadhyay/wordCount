package wordCount.dao;

import wordCount.util.LoggerHandler;
import wordCount.util.LoggerHandler.DebugLevel;

/**
 * @author shashiupadhyay
 *
 */
public class Word implements Cloneable, Comparable<Word> {
	private String word_content;
	private int wordCount;
	private int numberOfCharacters;

	/**
	 * @param numberOfCharacters the numberOfCharacters to set
	 */
	public void setNumberOfCharacters(int numberOfCharacters) {
		this.numberOfCharacters = numberOfCharacters;
	}

	/**
	 * @param wordIn
	 */
	public Word(String wordIn) {
		this(wordIn, 0);
		LoggerHandler.writeMessage("\tConstructor : " + this.getClass().getSimpleName(), DebugLevel.CONSTRUCTOR);
	}

	/**
	 * @param wordIn
	 * @param wordCountIn
	 */
	public Word(String wordIn, int wordCountIn) {
		super();
		this.word_content = wordIn;
		this.wordCount = wordCountIn;
		this.numberOfCharacters = wordIn.length();
		LoggerHandler.writeMessage("\tConstructor : " + this.getClass().getSimpleName(), DebugLevel.CONSTRUCTOR);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Word nextWordIn) {
		return nextWordIn.getWord().compareTo(this.getWord());
	}

	/**
	 * @return the word_content
	 */
	public String getWord() {
		return word_content;
	}

	/**
	 * @return the wordCount
	 */
	public int getWordCount() {
		return wordCount;
	}

	/**
	 * @param wordCount the wordCount to set
	 */
	public void setWordCount(int wordCountIn) {
		this.wordCount = wordCountIn;
	}

	/**
	 * @return the numberOfCharacters
	 */
	public int getNumberOfCharacters() {
		return numberOfCharacters;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("Word: " + word_content);
		sb.append("\tWord Count: " + wordCount);
		sb.append("\tCharacter Count: " + (wordCount*word_content.length()));
		sb.append("]");
		return sb.toString();
	}
}
