package com.agamurad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface IPhotoController {

	public ResponseEntity<String> uploadFile(MultipartFile file);
	
	public ResponseEntity<?> getAllPhoto();
}
