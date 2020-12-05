package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
