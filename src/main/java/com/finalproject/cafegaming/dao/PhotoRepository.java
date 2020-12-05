package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo,String> {
}
