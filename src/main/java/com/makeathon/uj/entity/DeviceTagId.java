package com.makeathon.uj.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DeviceTagId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String deviceId;
	private String tagId;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	
	public DeviceTagId() {
	}
	public DeviceTagId(String deviceId, String tagId) {
		super();
		this.deviceId = deviceId;
		this.tagId = tagId;
	}
	
}
