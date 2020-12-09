package com.finalproject.cafegaming.service.category;

import com.finalproject.cafegaming.dao.CategoryRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AuPhan
 */

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
    public Boolean update(Category category) {
        Category category1 = findById(category.getId());
        category1.setName(category.getName());
        category1.setCode(category.getCode());
        category1.setStatus(category.getStatus());
        category1.setFoods(category.getFoods());
        return save(category1);
    }

    @Override
    public Boolean delete(String id) {
        Category category = findById(id);
        category.setStatus("Non Active");
        return save(category);
    }

    @Override
    public Category findById(String s) {

        return categoryRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
