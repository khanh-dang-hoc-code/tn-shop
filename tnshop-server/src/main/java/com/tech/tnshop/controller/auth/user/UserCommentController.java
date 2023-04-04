package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.dto.request.comment.AddNewCommentRequest;
import com.tech.tnshop.dto.request.comment.UpdateCommentRequest;
import com.tech.tnshop.service.impl.CommentServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 09:35
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${user-auth}/comment")
@RequiredArgsConstructor
public class UserCommentController {
    private final CommentServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<Object> createNewComment(@RequestBody AddNewCommentRequest request, HttpServletRequest servletRequest) {
        return service.addNewComment( servletRequest, request);
    }


    @PutMapping("/update")
    public ResponseEntity<Object> updateCommentInPost(HttpServletRequest servletRequest, @RequestBody UpdateCommentRequest request) {
        return service.updateComment(servletRequest, request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCommentInPost(HttpServletRequest servletRequest,@RequestParam String commentId) {
        return service.removeComment(servletRequest, commentId);
    }
}
