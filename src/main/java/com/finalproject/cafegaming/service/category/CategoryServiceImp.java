package com.finalproject.cafegaming.service.category;

import com.finalproject.cafegaming.dao.CategoryRepository;
import com.finalproject.cafegaming.model.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImp implements CategoryService{

    final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).getContent();
    }

    @Override
    public Boolean save(Category category) {


        return categoryRepository.save(category) instanceof Category;
    }

    @Override
    public Boolean update(Category district) {






        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public Category findById(String s) {
        return null;
    }
}
