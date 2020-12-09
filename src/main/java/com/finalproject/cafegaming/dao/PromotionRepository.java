package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Promotion;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * @author AuPhan
 */

public interface PromotionRepository extends MongoRepository<Promotion,String> {
}
