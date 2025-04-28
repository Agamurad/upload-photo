package com.agamurad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agamurad.model.DtoProduct;

public interface ProductRepository extends MongoRepository<DtoProduct, String> {

}
