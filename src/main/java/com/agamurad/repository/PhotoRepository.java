package com.agamurad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agamurad.model.DtoPhoto;

@Repository
public interface PhotoRepository extends MongoRepository<DtoPhoto, String> {

	
}
