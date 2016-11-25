package com.infy.jnana.entity;

public class ReportEntity {

	private String label;
	private int value;
	/**
	 * @return the label
	 */
	public String getlabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setlabel(String label) {
		this.label = label;
	}
	/**
	 * @return the value
	 */
	public int getvalue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setvalue(int value) {
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportEntity [label=" + label + ", value=" + value + "]";
	}
	/**
	 * 
	 */
	public ReportEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
