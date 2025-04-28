package com.agamurad.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.agamurad.model.DtoProduct;

public interface IProductService {

	void addProduct(DtoProduct dtoProduct, MultipartFile file);
	
	public ResponseEntity<?> getAllProduct();
}
