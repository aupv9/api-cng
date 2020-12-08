package com.finalproject.cafegaming.service.photo;

import com.finalproject.cafegaming.model.Photo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhotoService {
    List<Photo> findAll(Pageable pageable);
    Boolean save(Photo genre);
    Boolean update(Photo genre);
    Boolean delete(String id);
    Photo findById(String s);
    String sendPhotoToCloud();
}
