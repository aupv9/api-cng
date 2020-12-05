package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food,String> {
}
