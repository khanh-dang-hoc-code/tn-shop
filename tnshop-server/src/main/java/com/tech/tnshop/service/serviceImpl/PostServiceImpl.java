package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.mapper.PostMapper;
import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.dto.request.post.AddNewPostRequest;
import com.tech.tnshop.dto.request.post.UpdatePostRequest;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.dto.response.MessageResponse;
import com.tech.tnshop.entity.Post;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.IPostRepository;
import com.tech.tnshop.service.IPostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;

    private final PostImageServiceImpl postImageService;

    public Post findPostById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find the post " + id));
    }

    @Override
    public ResponseEntity<Object> getPostById(String id) {
        return ResponseEntity.ok(new AbstractResponse(findPostById(id)));
    }

    @Override
    public ResponseEntity<Object> createNewPost(HttpServletRequest servletRequest, AddNewPostRequest request) {
        Post post = PostMapper.mapToPostEntity(request);
        postRepository.save(post);
        request.getImageList().forEach(s -> {
            postImageService.saveImageToBrand(post, new AddNewImageRequest("", s.getName(), s.getUrl()));
        });
        return ResponseEntity.ok(new AbstractResponse(post));
    }

    @Override
    public ResponseEntity<Object> updatePost(UpdatePostRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deletePost(String postId) {
        postRepository.deleteById(postId);
        return ResponseEntity.ok(new MessageResponse("Delete post " + postId + " successfully"));
    }

    @Override
    public ResponseEntity<Object> deleteListPost(List<String> postIds) {
        postRepository.deleteAllById(postIds);
        return ResponseEntity.ok(new MessageResponse("Delete post successfully"));
    }

    @Override
    public ResponseEntity<Object> getAllPost(int index, int limit) {
        return null;
    }
}
