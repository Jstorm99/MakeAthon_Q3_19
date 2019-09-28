package com.makeathon.uj.beans;

public class ResponseBean {

	private String message;
	private String status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ResponseBean(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	
	
}
