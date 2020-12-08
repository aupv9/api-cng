package com.finalproject.cafegaming.service.comment;

import com.finalproject.cafegaming.model.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 * @author AuPhan
 */
public interface CommentService {
    List<Comment> findAll(Pageable pageable);
    List<Comment> findAllByBooth(String s,Pageable pageable);
    Boolean save(Comment district);
    Boolean update(Comment district);
    Boolean delete(String id);
    Comment findById(String s);
}
