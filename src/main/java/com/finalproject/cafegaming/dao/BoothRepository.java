package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Booth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author AuPhan
 */

public interface BoothRepository extends MongoRepository<Booth,String> {

    Page<Booth> findAllByTitleContaining(String title,Pageable pageable);
//    Page<Booth> findAll(Pageable pageable);

}