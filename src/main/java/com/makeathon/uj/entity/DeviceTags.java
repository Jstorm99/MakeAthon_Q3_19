package com.makeathon.uj.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "device_tags")
public class DeviceTags {

	
	@EmbeddedId
	private DeviceTagId deviceTagId;
	
	private Long frequency;

	
	public DeviceTagId getDeviceTagId() {
		return deviceTagId;
	}

	public void setDeviceTagId(DeviceTagId deviceTagId) {
		this.deviceTagId = deviceTagId;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}
	
	
	
}
