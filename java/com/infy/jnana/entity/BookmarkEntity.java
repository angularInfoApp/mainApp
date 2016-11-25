package com.infy.jnana.entity;

public class BookmarkEntity {
	
	
	private int book_id;
	private String user_id;
	private String doc_name;
	private String doc_url;
	private int status;
	/**
	 * @return the book_id
	 */
	public int getBook_id() {
		return book_id;
	}
	/**
	 * @param book_id the book_id to set
	 */
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the doc_name
	 */
	public String getDoc_name() {
		return doc_name;
	}
	/**
	 * @param doc_name the doc_name to set
	 */
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	/**
	 * @return the doc_url
	 */
	public String getDoc_url() {
		return doc_url;
	}
	/**
	 * @param doc_url the doc_url to set
	 */
	public void setDoc_url(String doc_url) {
		this.doc_url = doc_url;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookmarkEntity [book_id=" + book_id + ", user_id=" + user_id + ", doc_name=" + doc_name + ", doc_url="
				+ doc_url + ", status=" + status + "]";
	}
	/**
	 * 
	 */
	public BookmarkEntity() {
		super();
	}
	
	

}
