package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.post.AddNewPostRequest;
import com.tech.tnshop.dto.request.post.UpdatePostRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface IPostService {
    ResponseEntity<Object> createNewPost(HttpServletRequest servletRequest, AddNewPostRequest request);
    ResponseEntity<Object> updatePost(UpdatePostRequest request);
    ResponseEntity<Object> deletePost(String postId);
    ResponseEntity<Object> deleteListPost(List<String> postIds);
    ResponseEntity<Object> getPostById(String postId);

    ResponseEntity<Object> getAllPost(int index, int limit);


}
