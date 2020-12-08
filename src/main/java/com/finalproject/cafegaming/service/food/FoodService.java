package com.finalproject.cafegaming.service.food;

import com.finalproject.cafegaming.model.Food;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    List<Food> findAll(Pageable pageable);
    List<Food> findAllByCategory(String code, Pageable pageable);
    Boolean save(Food food);
    Boolean update(Food food);
    Boolean delete(String id);
    Food findById(String s);
}
