package com.finalproject.cafegaming.service.food;

import com.finalproject.cafegaming.dao.FoodRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Food;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodServiceImp implements FoodService{

    final FoodRepository foodRepository;

    public FoodServiceImp(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    @Override
    public List<Food> findAll(Pageable pageable) {
        return foodRepository.findAll(pageable).toList();
    }

    @Override
    public List<Food> findAllByCategory(String code, Pageable pageable) {

        return foodRepository.findAllByCategory_Code(code,pageable).toList();
    }

    @Override
    public Boolean save(Food food) {


        return foodRepository.save(food) instanceof Food;
    }

    @Override
    public Boolean update(Food food) {
        Food food1 = findById(food.getId());
        food1.setCode(food.getCode());
        food1.setName(food.getName());
        food1.setPrice(food.getPrice());
        food1.setStatus(food.getStatus());
        food1.setCategory(food.getCategory());
        return save(food1);
    }

    @Override
    public Boolean delete(String id) {
        Food food1 = findById(id);
        food1.setStatus("Not active");
        return save(food1);
    }

    @Override
    public Food findById(String s) {
        return foodRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
