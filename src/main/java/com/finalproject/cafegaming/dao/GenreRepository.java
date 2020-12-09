package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * @author AuPhan
 */

public interface GenreRepository extends MongoRepository<Genre,String> {

}
