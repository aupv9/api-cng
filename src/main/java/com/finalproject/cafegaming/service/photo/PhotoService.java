package com.finalproject.cafegaming.service.photo;

import com.finalproject.cafegaming.model.Photo;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 * @author AuPhan
 */

public interface PhotoService {
    List<Photo> findAll(Pageable pageable);
    Boolean save(Photo genre);
    Boolean update(Photo genre);
    Boolean delete(String id);
    Photo findById(String s);
    Photo sendPhotoToCloud(byte[] file) throws IOException;
}
