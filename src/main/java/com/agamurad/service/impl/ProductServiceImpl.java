package com.agamurad.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agamurad.constant.TowardTheFutureFolderConstant;
import com.agamurad.model.DtoPhoto;
import com.agamurad.model.DtoProduct;
import com.agamurad.repository.ProductRepository;
import com.agamurad.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
    public void addProduct(DtoProduct dtoProduct, MultipartFile file) {
        DtoPhoto savedPhoto = saveFile(file);
        dtoProduct.setPhoto(savedPhoto);
        productRepository.save(dtoProduct);
    }

    private DtoPhoto saveFile(MultipartFile file) {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(TowardTheFutureFolderConstant.TOWARD_THE_FUTURE_FOLDER_UPLOAD)
                .resolve(fileName);

        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            DtoPhoto fileDoc = new DtoPhoto(
                    fileName,
                    filePath.toString(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    ""
            );
            return fileDoc;

        } catch (IOException e) {
            throw new RuntimeException("File could not be saved: " + e.getMessage(), e);
        }
    }

	@Override
	public ResponseEntity<?> getAllProduct() {
		List<DtoProduct> products = productRepository.findAll();
		if (products.size() > 0) {
			return new ResponseEntity<List<DtoProduct>>(products, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<DtoProduct>>(products, HttpStatus.NOT_FOUND);
		}
	}
	
}
