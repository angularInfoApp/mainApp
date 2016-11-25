package com.infy.jnana.entity;

public class SearchTag {

	private int id;
	private String searchTag;
	private int count;
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
	 * @return the searchTag
	 */
	public String getSearchTag() {
		return searchTag;
	}
	/**
	 * @param searchTag the searchTag to set
	 */
	public void setSearchTag(String searchTag) {
		this.searchTag = searchTag;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchTag [id=" + id + ", searchTag=" + searchTag + ", count=" + count + "]";
	}
	/**
	 * 
	 */
	public SearchTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
