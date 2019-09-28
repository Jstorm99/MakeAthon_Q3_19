package com.makeathon.uj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makeathon.uj.beans.DeviceDataBean;
import com.makeathon.uj.beans.DeviceTagBean;
import com.makeathon.uj.beans.ResponseBean;
import com.makeathon.uj.entity.DeviceTags;
import com.makeathon.uj.exceptions.DeviceDataException;
import com.makeathon.uj.service.DeviceDataService;

@CrossOrigin
@RestController
@RequestMapping("/device")
public class DeviceController {

	@Autowired
	DeviceDataService deviceService;
	
	Logger logger = LoggerFactory.getLogger(DeviceController.class);
	
	@PostMapping("/registerDevice")
	public ResponseEntity<ResponseBean> registerDevice(
			@RequestBody DeviceDataBean deviceBean) throws DeviceDataException
	{
		
		String deviceID = deviceService.registerDevice(deviceBean);
		return new ResponseEntity<>(new ResponseBean("device registered with deviceId"+deviceID,"OK"),HttpStatus.OK);
	}
	
	@GetMapping("/live/{deviceId}")
	public ResponseEntity<ResponseBean> updateDeviceHealth(
			@PathVariable("deviceId") String id)
	{
		logger.error("got id as : "+id);
		String deviceId = deviceService.updateDeviceHealth(id);
		return new ResponseEntity<>(new ResponseBean("updated status for device id "+deviceId,"ok"),HttpStatus.OK);
	}
	
	@GetMapping("/getAllRegisteredDevices")
	public ResponseEntity<List<DeviceDataBean>> getAllRegisteredDevices(){
		
		return new ResponseEntity<>(deviceService.getAllRegisteredDevice(),HttpStatus.OK);
	}
	
	@PostMapping("/updateDeviceData")
	public ResponseEntity<ResponseBean> updateDeviceData(
			@RequestBody DeviceDataBean dataBean) throws DeviceDataException
	{
		deviceService.updateDeviceData(dataBean);
		return new ResponseEntity<>(new ResponseBean("Device Data updated successfully","ok"),HttpStatus.OK);
	}
	
	@PostMapping("/addDeviceTags")
	public ResponseEntity<ResponseBean> addDataInDeviceTag(
			@RequestBody DeviceTagBean deviceTagBean)
	{
		
		DeviceTags deviceTags = deviceService.addDataInDeviceTag(deviceTagBean);
		return new ResponseEntity<>(new ResponseBean("added new deviceTag with id : "+deviceTags.getDeviceTagId().getDeviceId(),"OK"),HttpStatus.OK);
	}
	
}
