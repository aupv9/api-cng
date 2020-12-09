package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Category;
import com.finalproject.cafegaming.model.Food;
import com.finalproject.cafegaming.service.food.FoodService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @author AuPhan
 */

@RestController
@RequestMapping("/api/v1")
public class FoodController {

    final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping(value = "/foods",produces = "application/json")
    public ResponseEntity<List<Food>> getFoods(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10")int size
    ){
        Pageable paging = PageRequest.of(page, size);

        List<Food> foods = foodService.findAll(paging);

        return  foods != null && !foods.isEmpty()? new ResponseEntity<>(foods, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/food",produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Validated Food food){
        return  foodService.save(food) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/food")
    public ResponseEntity<?> update(@RequestBody @Validated Food food){
        return  foodService.update(food) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/food")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  foodService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
