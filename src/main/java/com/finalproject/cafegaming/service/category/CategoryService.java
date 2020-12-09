package com.finalproject.cafegaming.service.category;

import com.finalproject.cafegaming.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 * @author AuPhan
 */

public interface CategoryService {
    List<Category> findAll(Pageable pageable);
    Boolean save(Category district);
    Boolean update(Category district);
    Boolean delete(String id);
    Category findById(String s);
}
