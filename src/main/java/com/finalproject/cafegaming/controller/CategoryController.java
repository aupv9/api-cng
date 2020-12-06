package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Category;
import com.finalproject.cafegaming.service.category.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(value = "/categories",produces = "application/json")
    public ResponseEntity<List<Category>> getCategorys(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10")int size
    ){
        Pageable paging = PageRequest.of(page, size);

        List<Category> categoryList = categoryService.findAll(paging);

        return  categoryList != null && !categoryList.isEmpty()? new ResponseEntity<>(categoryList, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/category",produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Validated Category category){
        return  categoryService.save(category) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/category")
    public ResponseEntity<?> update(@RequestBody @Validated Category category){
        return  categoryService.update(category) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/category")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  categoryService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
