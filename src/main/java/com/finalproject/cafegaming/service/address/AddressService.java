package com.finalproject.cafegaming.service.address;

import com.finalproject.cafegaming.model.Address;
import com.finalproject.cafegaming.model.District;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {

    List<Address> findAll(Pageable pageable);
    Boolean save(Address district);
    Boolean update(Address district);
    Boolean delete(String id);
    Address findById(String s);
}
