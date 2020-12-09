package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * @author AuPhan
 */

public interface ProvinceRepository extends MongoRepository<Province,String> {

    Page<Province> findAll(Pageable pageable);
    Province findByCode(String code);
}
