package com.finalproject.cafegaming.service.photo;

import com.finalproject.cafegaming.config.GoogleDriveConfig;
import com.finalproject.cafegaming.dao.PhotoRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Photo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
/**
 * @author AuPhan
 */

@Service
public class PhotoServiceImp implements PhotoService{


    final PhotoRepository photoRepository;
    final GoogleDriveConfig googleDriveConfig;
    public PhotoServiceImp(PhotoRepository photoRepository, GoogleDriveConfig googleDriveConfig) {
        this.photoRepository = photoRepository;
        this.googleDriveConfig = googleDriveConfig;
    }

    @Override
    public List<Photo> findAll(Pageable pageable) {
        return photoRepository.findAll(pageable).toList();
    }

    @Override
    public Boolean save(Photo photo) {
        return photoRepository.save(photo) instanceof Photo;
    }

    @Override
    public Boolean update(Photo photo) {
        Photo photo1 = findById(photo.getId());
        photo1.setBooth(photo.getBooth());
        photo1.setTitle(photo.getTitle());
        photo1.setCode(photo.getCode());
        photo1.setUrl(photo.getUrl());
        photo1.setStatus(photo.getStatus());
        return save(photo);
    }

    @Override
    public Boolean delete(String id) {
        Photo photo = findById(id);
        photo.setStatus("Not active");
        return save(photo);
    }

    @Override
    public Photo findById(String s) {
        return photoRepository.findById(s).orElseThrow(ResourceException::new);
    }

    @Override
    public Photo sendPhotoToCloud(byte[] file) throws IOException {
       return googleDriveConfig.uploadImage(file);
    }


}
