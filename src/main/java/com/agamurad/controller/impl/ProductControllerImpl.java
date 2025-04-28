package com.agamurad.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agamurad.controller.IProductController;
import com.agamurad.model.DtoProduct;
import com.agamurad.service.IProductService;

@RestController
@RequestMapping("/rest/api/product")
public class ProductControllerImpl implements IProductController {

	@Autowired
	private IProductService productService;
	
	@PostMapping(path = "/add")
	@Override
    public ResponseEntity<?> addProduct(@ModelAttribute DtoProduct dtoProduct, @RequestParam("file") MultipartFile file) {
        productService.addProduct(dtoProduct, file);
        return ResponseEntity.ok("Product successfully added!");
    }

	@GetMapping(path = "/list")
	@Override
	public ResponseEntity<?> getAllProduct() {
		return productService.getAllProduct();
	}
	
}
