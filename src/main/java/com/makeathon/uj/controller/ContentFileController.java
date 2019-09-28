package com.makeathon.uj.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.makeathon.uj.beans.FileUploadBean;
import com.makeathon.uj.beans.ResponseBean;
import com.makeathon.uj.entity.ContentFiles;
import com.makeathon.uj.exceptions.FileStorageException;
import com.makeathon.uj.service.ContentFileStorageService;

@CrossOrigin
@RestController
@RequestMapping("/storage")
public class ContentFileController {

	Logger logger = LoggerFactory.getLogger(ContentFileController.class);
	
	@Autowired
	ContentFileStorageService contentFileStorageService;
	
	@PostMapping("/uploadFile")
	public ResponseEntity<ResponseBean> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("imageTag") String tag) throws FileStorageException{
		
		contentFileStorageService.storeFileinDB(file,tag);
		ResponseBean respBean = new ResponseBean("file Uploaded","OK");
		return new ResponseEntity<>(respBean,HttpStatus.OK);
		
	}
	
	@PostMapping("/uploadMultipleFiles")
	public ResponseEntity<ResponseBean> uploadMultipleFiles(
			@RequestParam("file") MultipartFile[] files,@RequestParam("imageTag") String tag) throws FileStorageException
	{
		
		if(files.length<1)
			throw new FileStorageException("no file selected or missing parameter file");
		
		logger.error("I am here");
		for(MultipartFile file : files) {
			logger.error("files");
			contentFileStorageService.storeFileinDB(file,tag);
		}
		
		return ResponseEntity.ok().body(new ResponseBean("All files uploaded successfully","ok"));
	}
	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws FileStorageException{
		
		
		ContentFiles contentFiles = contentFileStorageService.getFileFromDB(Integer.parseInt(fileId));
	
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentFiles.getFileType()))
				.body(new ByteArrayResource(contentFiles.getData()));
	}
	
	@GetMapping("/getAllFilesList")
	public ResponseEntity<List<FileUploadBean>> getAllFileDetails(){
		
		List<FileUploadBean> allFileDetails = new ArrayList<>();
		for(ContentFiles file : contentFileStorageService.getAllFilesDetails()) {
			
			allFileDetails.add(new FileUploadBean(file.getFileId(),file.getFileName(),file.getFileType()));
		}
		
		return new ResponseEntity<>(allFileDetails,HttpStatus.OK);
	}
	
	@GetMapping("/getFileDetail/{fileId}")
	public ResponseEntity<FileUploadBean> getFileDetails(@PathVariable String fileId) throws NumberFormatException, FileStorageException{
		 
		ContentFiles file = contentFileStorageService.getFileFromDB(Integer.parseInt(fileId));
		return new ResponseEntity<>(new FileUploadBean(file.getFileId(),file.getFileName(),file.getFileType()),HttpStatus.OK);
	}
	
}
