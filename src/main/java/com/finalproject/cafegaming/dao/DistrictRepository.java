package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DistrictRepository extends MongoRepository<District,String> {

    Page<District> findAllByIdLocation(String s, Pageable pageable);
    Page<District> findAll(Pageable pageable);
    List<District> findAllByIdLocation(String id);

}
