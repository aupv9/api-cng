package com.finalproject.cafegaming.service.booth;

import com.finalproject.cafegaming.model.Booth;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoothService {
    List<Booth> findAll();
    Booth findById(String id);
    Boolean insert(Booth booth);
    Boolean update(Booth booth);
    List<Booth> findAllByDistrict(String province,String dis, Pageable pageable);
    List<Booth> findAllByProvince(String province,Pageable pageable);
    Boolean delete(String id);
    List<Booth> findAll(Pageable pageable);
    List<Booth> findAllByTitleContaining(String title, Pageable pageable);
}
