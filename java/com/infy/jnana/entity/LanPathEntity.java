package com.infy.jnana.entity;

public class LanPathEntity {
	
	private int id;
	private String userName;
	private String path;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	@Override
	public String toString() {
		return "LanPathEntity [id=" + id + ", userName=" + userName + ", path=" + path + "]";
	}
	
	
	public LanPathEntity() {
		super();
	}
	
	

}
