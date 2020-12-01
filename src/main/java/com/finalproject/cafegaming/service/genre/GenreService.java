package com.finalproject.cafegaming.service.genre;

import com.finalproject.cafegaming.model.District;
import com.finalproject.cafegaming.model.Genre;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenreService {
    List<Genre> findAll(Pageable pageable);
    Boolean save(Genre genre);
    Boolean update(Genre genre);
    Boolean delete(String id);
    Genre findById(String s);
}
