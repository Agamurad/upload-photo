package com.agamurad.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface IPhotoService {

	public String saveFile(MultipartFile file);
	
	public ResponseEntity<?> getAllPhoto();
}
