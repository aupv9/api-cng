package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DistrictRepository extends MongoRepository<District,String> {

    Page<District> findAllByProvinceCode(String code,Pageable pageable);
}
