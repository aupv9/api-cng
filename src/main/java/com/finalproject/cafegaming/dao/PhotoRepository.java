package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * @author AuPhan
 */

public interface PhotoRepository extends MongoRepository<Photo,String> {
}
