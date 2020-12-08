package com.finalproject.cafegaming.service.comment;

import com.finalproject.cafegaming.dao.CommentRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AuPhan
 */

@Service
public class CommentServiceImp implements CommentService{

    final CommentRepository commentRepository;

    public CommentServiceImp(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable).toList();
    }

    @Override
    public List<Comment> findAllByBooth(String s, Pageable pageable) {
        return commentRepository.findAllByBooth_Id(s,pageable).toList();
    }

    @Override
    public Boolean save(Comment comment) {
        return commentRepository.save(comment) instanceof Comment;
    }

    @Override
    public Boolean update(Comment comment) {
        Comment comment1 = findById(comment.getId());
        comment1.setTitle(comment.getTitle());
        comment1.setContent(comment.getContent());
        comment1.setPoint(comment.getPoint());
        return save(comment1);
    }

    @Override
    public Boolean delete(String id) {
        Comment comment1 = findById(id);
        comment1.setStatus("Non");
        return save(comment1);
    }

    @Override
    public Comment findById(String s) {
        return commentRepository.findById(s).orElseThrow(ResourceException::new);
    }
}
