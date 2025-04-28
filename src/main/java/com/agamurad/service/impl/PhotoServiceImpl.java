package com.agamurad.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agamurad.constant.TowardTheFutureFolderConstant;
import com.agamurad.model.DtoPhoto;
import com.agamurad.repository.PhotoRepository;
import com.agamurad.service.IPhotoService;

@Service
public class PhotoServiceImpl implements IPhotoService {

	@Autowired
	private PhotoRepository photoRepository;

	

	@Override
	public ResponseEntity<?> getAllPhoto() {
		List<DtoPhoto> photos = photoRepository.findAll();
		if (photos.size() > 0) {
			return new ResponseEntity<List<DtoPhoto>>(photos, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<DtoPhoto>>(photos, HttpStatus.NOT_FOUND);
		}
	}



	@Override
	public String saveFile(MultipartFile file) {
		String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(TowardTheFutureFolderConstant.TOWARD_THE_FUTURE_FOLDER_UPLOAD)
                .resolve(fileName);

        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            DtoPhoto fileDoc = new DtoPhoto(
                    fileName,
                    filePath.toString(),
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),""
            );
            photoRepository.save(fileDoc);

        } catch (IOException e) {
            throw new RuntimeException("File could not be saved: " + e.getMessage(), e);
        }

        return filePath.toString();
	}
	
	

}
