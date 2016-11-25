package com.infy.jnana.entity;

import java.util.Date;

public class IncrDocEntity {


	private String label;
	private int value;
	
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IncrDocEntity [ label=" + label + ", value=" + value + "]";
	}
	/**
	 * 
	 */
	public IncrDocEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
