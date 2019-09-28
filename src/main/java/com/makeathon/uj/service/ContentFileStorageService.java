package com.makeathon.uj.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.makeathon.uj.entity.ContentFiles;
import com.makeathon.uj.exceptions.FileStorageException;
import com.makeathon.uj.repository.ContentFilesRepository;

@Service
public class ContentFileStorageService {

	@Autowired
	ContentFilesRepository filesRepository;
	
	Logger logger = LoggerFactory.getLogger(ContentFileStorageService.class);
	
	public ContentFiles storeFileinDB(MultipartFile file,String tag) throws FileStorageException {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains(".."))
				throw new FileStorageException("file name contains invalid characters");
		
			if(!file.getContentType().contains("png"))
				throw new FileStorageException("Invalid File format, only png supported.");
				
			logger.error("uplaoding file : "+fileName);
			ContentFiles contentFiles = new ContentFiles(fileName,file.getContentType(),tag,file.getBytes());
			filesRepository.save(contentFiles);
			
			return contentFiles;
		}
		catch(IOException e) {
			logger.error(e.getMessage());
			throw new FileStorageException("could not store file : "+fileName+" error occured");
		}
	}
	
	public ContentFiles getFileFromDB(Integer fileId) throws FileStorageException {
		return filesRepository.findById(fileId)
				.orElseThrow(()->new FileStorageException("file not found with id :"+fileId));
	}
	
	public List<ContentFiles> getAllFilesDetails(){
	
		List<ContentFiles> allFilesList= filesRepository.findAll();
		return allFilesList;
	}
}
