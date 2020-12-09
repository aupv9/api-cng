package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.Genre;
import com.finalproject.cafegaming.service.genre.GenreService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @author AuPhan
 */

@RestController
@RequestMapping("/api/v1")
public class GenreController {

    final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(value = "/genres",produces = "application/json")
    public ResponseEntity<List<Genre>> getGenre(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10")int size
    ){
        List<Genre> genreList = null;
        Pageable paging = PageRequest.of(page, size);

        genreList = genreService.findAll(paging);

        return  genreList != null ? new ResponseEntity<>(genreList, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/genre/{id}",produces = "application/json")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        Genre genre = genreService.findById(id);
        return  genre != null ? new ResponseEntity<>(genre, HttpStatus.CREATED):
                new ResponseEntity<>(new Genre(),HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/genre",produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Validated Genre genre){
        return  genreService.save(genre) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/genre")
    public ResponseEntity<?> update(@RequestBody @Validated Genre genre){
        return  genreService.update(genre) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/genre")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  genreService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.CREATED):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}
