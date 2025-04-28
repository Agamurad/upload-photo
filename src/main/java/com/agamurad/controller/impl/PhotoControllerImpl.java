package com.agamurad.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agamurad.controller.IPhotoController;
import com.agamurad.service.IPhotoService;

@RestController
@RequestMapping("/rest/api/photo")
public class PhotoControllerImpl implements IPhotoController {

	@Autowired
	private IPhotoService photoService;


	@GetMapping(path = "/list")
	@Override
	public ResponseEntity<?> getAllPhoto() {
		return photoService.getAllPhoto();
	}

	@PostMapping(path = "/upload")
	@Override
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		String path = photoService.saveFile(file);
        return ResponseEntity.ok("File uploaded to: " + path);
	}
	
	
	

}
