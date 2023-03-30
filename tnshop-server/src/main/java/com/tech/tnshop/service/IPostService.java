package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.post.AddNewPostRequest;
import com.tech.tnshop.dto.request.post.UpdatePostRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IPostService {
    ResponseEntity<Object> createNewPost(AddNewPostRequest request);
    ResponseEntity<Object> updatePost(UpdatePostRequest request);
    ResponseEntity<Object> deletePost(String postId);
    ResponseEntity<Object> getAllPost(int index, int limit);

}
