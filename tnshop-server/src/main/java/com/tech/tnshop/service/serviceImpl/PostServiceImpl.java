package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.post.AddNewPostRequest;
import com.tech.tnshop.dto.request.post.UpdatePostRequest;
import com.tech.tnshop.entity.Post;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.IPostRepository;
import com.tech.tnshop.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;

    public Post getPostById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find the post " + id));
    }

    @Override
    public ResponseEntity<Object> createNewPost(AddNewPostRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updatePost(UpdatePostRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deletePost(String postId) {
        Post postDelete = getPostById(postId);
        postRepository.delete(postDelete);
        return ResponseEntity.ok("Delete post " + postId + " successfully");
    }

    @Override
    public ResponseEntity<Object> getAllPost(int index, int limit) {
        return null;
    }
}
