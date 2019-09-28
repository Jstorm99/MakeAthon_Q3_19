package com.makeathon.uj.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "device_data")
public class DeviceData {
	
	@Id
	private String deviceId;
	private String resolution;
	private String deviceName;
	private String registrationStatus;
	@Column(length = 1000)
	private String tags;
	
	 @CreationTimestamp
	 private LocalDateTime createDateTime;
	 
	 @UpdateTimestamp
	 private LocalDateTime updateDateTime;
	    
	private String location;

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

//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}

//	public Date getModifyDate() {
//		return modifyDate;
//	}
//
//	public void setModifyDate(Date modifyDate) {
//		this.modifyDate = modifyDate;
//	}

	public DeviceData() {
		// TODO Auto-generated constructor stub
	}
	
	public DeviceData(String deviceId, String resolution, String deviceName, String registrationStatus, String tags,
			String location) {
		super();
		this.deviceId = deviceId;
		this.resolution = resolution;
		this.deviceName = deviceName;
		this.registrationStatus = registrationStatus;
		this.tags = tags;
		this.location = location;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	
	
	
}
