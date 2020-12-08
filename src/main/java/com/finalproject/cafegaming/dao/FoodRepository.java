package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food,String> {

    Page<Food> findAllByCategory_Code(String code,Pageable pageable);
}
