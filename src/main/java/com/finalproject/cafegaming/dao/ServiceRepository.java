package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceRepository extends MongoRepository<Service,String> {
}
