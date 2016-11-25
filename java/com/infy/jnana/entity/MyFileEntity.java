package com.infy.jnana.entity;

import java.util.List;

public class MyFileEntity {
	private String id;
	private String url;
	private String fileName;
	private String extName;
	private String fileType;
	private String author;
	private int count;
	private String content;
	private String fileSize;
	private int avgRating;
	private int rateCount;
	private String date;
	private int status;
	private String highlightTxt;
	private List<String> documents;
	/**
	 * @return the documents
	 */
	public List<String> getDocuments() {
		return documents;
	}
	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the extName
	 */
	public String getExtName() {
		return extName;
	}
	/**
	 * @param extName the extName to set
	 */
	public void setExtName(String extName) {
		this.extName = extName;
	}
	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	/**
	 * @return the avgRating
	 */
	public int getAvgRating() {
		return avgRating;
	}
	/**
	 * @param avgRating the avgRating to set
	 */
	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}
	/**
	 * @return the rateCount
	 */
	public int getRateCount() {
		return rateCount;
	}
	/**
	 * @param rateCount the rateCount to set
	 */
	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
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
	/**
	 * @return the highlightTxt
	 */
	public String getHighlightTxt() {
		return highlightTxt;
	}
	/**
	 * @param highlightTxt the highlightTxt to set
	 */
	public void setHighlightTxt(String highlightTxt) {
		this.highlightTxt = highlightTxt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyFileEntity [id=" + id + ", url=" + url + ", fileName=" + fileName + ", extName=" + extName
				+ ", fileType=" + fileType + ", author=" + author + ", count=" + count + ", content=" + content
				+ ", fileSize=" + fileSize + ", avgRating=" + avgRating + ", rateCount=" + rateCount + ", date=" + date
				+ ", status=" + status + ", highlightTxt=" + highlightTxt + ", documents=" + documents + "]";
	}
	/**
	 * 
	 */
	public MyFileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
