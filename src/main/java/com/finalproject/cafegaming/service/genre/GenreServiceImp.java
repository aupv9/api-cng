package com.finalproject.cafegaming.service.genre;

import com.finalproject.cafegaming.dao.GenreRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Genre;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GenreServiceImp implements GenreService{


    final GenreRepository genreRepository;

    public GenreServiceImp(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public List<Genre> findAll(Pageable pageable) {
        return genreRepository.findAll(pageable).getContent();
    }

    @Override
    public Boolean save(Genre genre) {

        return genreRepository.save(genre) instanceof Genre;
    }

    @Override
    public Boolean update(Genre genre) {
        Genre genre1 = findById(genre.getId());
        genre1.setCode(genre.getCode());
        genre1.setName(genre.getName());
        genre1.setStatus(genre.getStatus());
        return genreRepository.save(genre1) instanceof Genre;
    }

    @Override
    public Boolean delete(String id) {
        Genre genre = findById(id);
        genre.setStatus("Not Active");
        return genreRepository.save(genre) instanceof  Genre;
    }

    @Override
    public Genre findById(String s) {
        return genreRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
