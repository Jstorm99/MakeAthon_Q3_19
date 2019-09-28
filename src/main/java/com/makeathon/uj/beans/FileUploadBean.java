package com.makeathon.uj.beans;

public class FileUploadBean {

	private int fileId;
	private String fileName;
	private String fileType;
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public FileUploadBean(int fileId, String fileName, String fileType) {
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileType = fileType;
	
	}
	
	
	
}
