package com.finalproject.cafegaming.service.promotion;

import com.finalproject.cafegaming.model.Promotion;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 * @author AuPhan
 */

public interface PromotionService {
    List<Promotion> findAll(Pageable pageable);
    Boolean save(Promotion promotion);
    Boolean update(Promotion promotion);
    Boolean delete(String id);
    Promotion findById(String s);
}
