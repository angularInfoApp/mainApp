package com.infy.jnana.entity;

public class WordCloud {
	
	private int id;
	private String word;
	private int size;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WordCloud [id=" + id + ", word=" + word + ", size=" + size + "]";
	}
	/**
	 * 
	 */
	public WordCloud() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
