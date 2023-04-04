package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.service.impl.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${no-auth}/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceImpl service;

    @GetMapping("/get")
    public ResponseEntity<Object> getAllCommentInPost(@RequestParam String postId, @RequestParam int limit, @RequestParam int index) {
        return service.getAllComment(postId, index, limit);
    }
}
