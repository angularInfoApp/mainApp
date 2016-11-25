package com.infy.jnana.entity;

public class AdminEntity {
	
	private int slNo;
	private String userName;
	private int adminStatus;
	/**
	 * @return the slNo
	 */
	public int getSlNo() {
		return slNo;
	}
	/**
	 * @param slNo the slNo to set
	 */
	public void setSlNo(int slNo) {
		this.slNo = slNo;
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
	 * @return the adminStatus
	 */
	public int getAdminStatus() {
		return adminStatus;
	}
	/**
	 * @param adminStatus the adminStatus to set
	 */
	public void setAdminStatus(int adminStatus) {
		this.adminStatus = adminStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminEntity [slNo=" + slNo + ", userName=" + userName + ", adminStatus=" + adminStatus + "]";
	}
	/**
	 * 
	 */
	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
