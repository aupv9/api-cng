package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,String> {

}
