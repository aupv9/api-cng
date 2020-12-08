package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {

    Page<Comment> findAllByBooth_Id(String id, Pageable pageable);
}
