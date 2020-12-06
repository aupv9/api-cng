package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Photo;
import com.finalproject.cafegaming.service.photo.PhotoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PhotoController {

    final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping(value = "/photos",produces = "application/json")
    public ResponseEntity<List<Photo>> getPhotos(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10")int size
    ){
        Pageable paging = PageRequest.of(page, size);

        List<Photo> photoList = photoService.findAll(paging);

        return  photoList != null && !photoList.isEmpty()? new ResponseEntity<>(photoList, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/photo",produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Validated Photo photo){
        return  photoService.save(photo) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/photo")
    public ResponseEntity<?> update(@RequestBody @Validated Photo photo){
        return  photoService.update(photo) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/photo")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  photoService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
