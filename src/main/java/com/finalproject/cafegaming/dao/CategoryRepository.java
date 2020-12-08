package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {


}
