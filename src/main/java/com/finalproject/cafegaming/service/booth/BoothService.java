package com.finalproject.cafegaming.service.booth;

import com.finalproject.cafegaming.model.Booth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface BoothService {
    List<Booth> findAll();
    Booth findById(String id);
    Boolean insert(Booth booth);
    Boolean update(Booth booth);
    List<Booth> findByDistrict(String s);
    Boolean delete(String id);
    List<Booth> findAll(Pageable pageable);
    List<Booth> findAllByDistrict(String dis,Pageable pageable);
    List<Booth> findAllByZone(String dis,Pageable pageable);
    List<Booth> findAllByTitleContaining(String title, Pageable pageable);
}
