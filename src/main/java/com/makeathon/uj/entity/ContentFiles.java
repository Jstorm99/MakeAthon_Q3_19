package com.makeathon.uj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "content_files")
public class ContentFiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileId;
	
	private String fileName;
	
	private String fileType;
	
	private String imageTag;
	
	@Lob
	private byte[] data;
	
	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	
	
	public String getImageTag() {
		return imageTag;
	}

	public void setImageTag(String imageTag) {
		this.imageTag = imageTag;
	}

	public ContentFiles() {
	}
	
	public ContentFiles(String fileName, String fileType,String imageTag, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.imageTag = imageTag;
	}

	@Override
	public String toString() {
		return "ContentFiles [fileId=" + fileId + ", fileName=" + fileName + ", fileType=" + fileType+ "]";
	}
	
	
	
	
}
