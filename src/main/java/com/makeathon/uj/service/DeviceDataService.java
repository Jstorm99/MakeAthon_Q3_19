package com.makeathon.uj.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.makeathon.uj.beans.DeviceDataBean;
import com.makeathon.uj.beans.DeviceTagBean;
import com.makeathon.uj.entity.DeviceData;
import com.makeathon.uj.entity.DeviceTagId;
import com.makeathon.uj.entity.DeviceTags;
import com.makeathon.uj.exceptions.DeviceDataException;
import com.makeathon.uj.repository.DeviceDataRepository;
import com.makeathon.uj.repository.DeviceTagRepository;

@Service
public class DeviceDataService {

	@Autowired
	DeviceDataRepository deviceRepository;
	@Autowired
	DeviceTagRepository deviceTagRepository;
	
	Logger logger = LoggerFactory.getLogger(DeviceDataService.class);
	
	public String registerDevice(DeviceDataBean deviceBean) throws DeviceDataException {
		
		DeviceData data = getDeviceDataFromBean(deviceBean);
		if(deviceRepository.existsById(data.getDeviceId())) {
			throw new DeviceDataException("device already exists with this Id");
		}
		
		return deviceRepository.save(data).getDeviceId();
	
	}
	
	public String updateDeviceHealth(String deviceId) {
		
		String id=null;
		if(deviceRepository.existsById(deviceId)) {
			
			logger.error("in update service");
			
			DeviceData deviceData = deviceRepository.findById(deviceId)
													.orElse(null);
			
			if(deviceData!=null) {
				deviceData.setUpdateDateTime(LocalDateTime.now());
				id = deviceRepository.save(deviceData).getDeviceId();
			}
		}
		return id;
	}
	
	public List<DeviceDataBean> getAllRegisteredDevice(){
		
		List<DeviceData> listOfDevices = deviceRepository.findAll();
		List<DeviceDataBean> list = new ArrayList<>();
		for(DeviceData b : listOfDevices)
		{
			list.add(getDeviceBeanfromEntity(b));
		}
		
		return list;
	}
	
	
	public DeviceTags addDataInDeviceTag(DeviceTagBean bean) {
		
		DeviceTagId tagId = new DeviceTagId(bean.getDeviceId(),bean.getTagId());
		DeviceTags deviceTags = new DeviceTags();
		deviceTags.setDeviceTagId(tagId);
		deviceTags.setFrequency(bean.getFrequency());
		
		return deviceTagRepository.save(deviceTags);
		
	}
	
	public void updateDeviceData(DeviceDataBean bean) throws DeviceDataException {
		
		if(bean.getDeviceId()==null)
			throw new DeviceDataException("deviceId cannot be null.");
		
		DeviceData deviceDataEntity = deviceRepository.findById(bean.getDeviceId())
										.orElse(null);
		updateSpecificDetailsOfDeviceData(bean,deviceDataEntity);
		deviceRepository.save(deviceDataEntity);
	}
	
	private void updateSpecificDetailsOfDeviceData(DeviceDataBean bean, DeviceData deviceDataEntity) {
		
		if(!StringUtils.isEmpty(bean.getDeviceName()))
			deviceDataEntity.setDeviceName(bean.getDeviceName());
		
		if(!StringUtils.isEmpty(bean.getLocation()))
			deviceDataEntity.setLocation(bean.getLocation());
		
		if(!StringUtils.isEmpty(bean.getResolution()))
			deviceDataEntity.setResolution(bean.getResolution());
		if(!StringUtils.isEmpty(bean.getTags()))
			deviceDataEntity.setTags(bean.getTags());
		
	}

	private DeviceDataBean getDeviceBeanfromEntity(DeviceData data) {
		return new DeviceDataBean(
				data.getDeviceId(),
				data.getResolution(),
				data.getDeviceName(),
				data.getRegistrationStatus(),
				data.getTags(),data.getLocation(),
				data.getCreateDateTime(),
				data.getUpdateDateTime());
	}
	
	private DeviceData getDeviceDataFromBean(DeviceDataBean d) {
		
		return new DeviceData(d.getDeviceId(),d.getResolution(),d.getDeviceName(),d.getRegistrationStatus(),d.getTags(),d.getLocation());
	}
	
	
}
