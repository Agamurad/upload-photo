package com.agamurad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.agamurad.model.DtoProduct;

public interface IProductController {

	public ResponseEntity<?> addProduct(DtoProduct dtoProduct, MultipartFile file);
	
	public ResponseEntity<?> getAllProduct();
}
