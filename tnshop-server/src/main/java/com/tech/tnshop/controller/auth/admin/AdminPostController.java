package com.tech.tnshop.controller.auth.admin;

/*
 * @created 01/04/2023 - 09:36
 * @project tn-shop
 * @author  ngockhanh
 */

import com.tech.tnshop.dto.request.post.AddNewPostRequest;
import com.tech.tnshop.dto.request.post.RemoveListPostRequest;
import com.tech.tnshop.dto.request.post.UpdatePostRequest;
import com.tech.tnshop.service.impl.PostServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${admin-auth}/post")
@RequiredArgsConstructor
public class AdminPostController {
    private final PostServiceImpl postService;

    @GetMapping("/get")
    public ResponseEntity<Object> getPost(@RequestParam String postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/get-list")
    public ResponseEntity<Object> getListPost(@RequestParam int index, @RequestParam int limit) {
        return postService.getAllPost(index, limit);
    }


    @PostMapping("/add")
    public ResponseEntity<Object> addNewPost(HttpServletRequest servletRequest, @RequestBody AddNewPostRequest request) {
            return postService.createNewPost(servletRequest, request);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updatePost(@RequestBody UpdatePostRequest request) {
        return postService.updatePost(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deletePost(@RequestParam String postId) {
        return postService.deletePost(postId);
    }

    @DeleteMapping("/delete-list")
    public ResponseEntity<Object> deleteListPost(@RequestBody RemoveListPostRequest request) {
        return postService.deleteListPost(request.getIds());
    }
}
