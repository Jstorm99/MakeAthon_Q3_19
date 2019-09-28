package com.makeathon.uj.beans;

import java.time.LocalDateTime;

public class DeviceDataBean {

	private String deviceId;
	private String resolution;
	private String deviceName;
	private String registrationStatus;
	private String tags;
	private String location;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public DeviceDataBean() {}
	public DeviceDataBean(String deviceId, String resolution, String deviceName, String registrationStatus, String tags,
			String location) {
		this.deviceId = deviceId;
		this.resolution = resolution;
		this.deviceName = deviceName;
		this.registrationStatus = registrationStatus;
		this.tags = tags;
		this.location = location;
	}
	public DeviceDataBean(String deviceId, String resolution, String deviceName, String registrationStatus, String tags,
			String location, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
		super();
		this.deviceId = deviceId;
		this.resolution = resolution;
		this.deviceName = deviceName;
		this.registrationStatus = registrationStatus;
		this.tags = tags;
		this.location = location;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
	}
	
	
	
	
	
}
