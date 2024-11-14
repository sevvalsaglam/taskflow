package com.workintech.taskflow.controller;


import com.workintech.taskflow.entity.Comment;
import com.workintech.taskflow.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody @Valid Comment comment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(comment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody @Valid Comment commentDetails) {
        return ResponseEntity.ok(commentService.updateComment(id, commentDetails));
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}

