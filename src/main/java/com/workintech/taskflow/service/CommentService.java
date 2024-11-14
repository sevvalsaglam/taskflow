package com.workintech.taskflow.service;

import com.workintech.taskflow.entity.Comment;
import com.workintech.taskflow.exception.ApiException;
import com.workintech.taskflow.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Comment not found", HttpStatus.NOT_FOUND));
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = getCommentById(id);
        comment.setContent(commentDetails.getContent());
        // Diğer alanlar burada güncellenebilir
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        Comment comment = getCommentById(id);
        commentRepository.delete(comment);
    }
}
