package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.comment.AddNewCommentRequest;
import com.tech.tnshop.dto.request.comment.UpdateCommentRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ICommentService {
    ResponseEntity<Object> getAllComment(String postId, int index, int limit);
    ResponseEntity<Object> addNewComment(HttpServletRequest servletRequest, AddNewCommentRequest request);
    ResponseEntity<Object> updateComment(HttpServletRequest servletRequest, UpdateCommentRequest request);
    ResponseEntity<Object> removeComment(HttpServletRequest servletRequest, String commentId);
}
