package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,String> {
    Page<Address> findAll(Pageable pageable);

}
