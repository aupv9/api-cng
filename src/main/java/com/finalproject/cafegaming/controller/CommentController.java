package com.finalproject.cafegaming.controller;

import com.finalproject.cafegaming.model.Category;
import com.finalproject.cafegaming.model.Comment;
import com.finalproject.cafegaming.model.Promotion;
import com.finalproject.cafegaming.service.comment.CommentService;
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
@RequestMapping("api/v1/")
public class CommentController {

    final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping(value = "/comments",produces = "application/json")
    public ResponseEntity<List<Comment>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10")int size
    ){
        Pageable paging = PageRequest.of(page, size);

        List<Comment> comments = commentService.findAll(paging);

        return  comments != null && !comments.isEmpty()? new ResponseEntity<>(comments, HttpStatus.OK):
                new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/comment",produces = "application/json")
    public ResponseEntity<Comment> findById(@RequestParam String id){

        Comment comments = commentService.findById(id);

        return  comments != null ? new ResponseEntity<>(comments, HttpStatus.OK):
                new ResponseEntity<>(new Comment(),HttpStatus.NOT_FOUND);
    }



    @PostMapping(value = "/comments",produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Validated Comment comment){
        return  commentService.save(comment) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/comments")
    public ResponseEntity<?> update(@RequestBody @Validated Comment comment){
        return  commentService.update(comment) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/comments")
    public ResponseEntity<?> delete(@RequestParam String id){
        return  commentService.delete(id) != null ? new ResponseEntity<>(true, HttpStatus.OK):
                new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
