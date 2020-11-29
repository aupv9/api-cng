package com.finalproject.cafegaming.service.district;

import com.finalproject.cafegaming.model.District;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DistrictService {

    List<District> findAll(Pageable pageable);
    List<District> findAllByLocation(String id);
    Boolean save(District district);
    Boolean update(District district);
    Boolean delete(String id);
    District findById(String s);

}
