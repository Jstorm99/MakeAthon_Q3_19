package com.makeathon.uj.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.makeathon.uj.beans.ResponseBean;
import com.makeathon.uj.exceptions.DeviceDataException;
import com.makeathon.uj.exceptions.FileStorageException;

@ControllerAdvice
public class AllExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(AllExceptionHandler.class);
	
	@ExceptionHandler(DeviceDataException.class)
	public ResponseEntity<ResponseBean> handleDeviceException(DeviceDataException e){ 
		logger.error(e.getMessage(),e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseBean(e.getMessage(),"Error"));
	}
	
	@ExceptionHandler(FileStorageException.class)
	public ResponseEntity<ResponseBean> handleFileException(FileStorageException e){ 
		logger.error(e.getMessage(),e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseBean(e.getMessage(),"Error"));
	}
	
}
