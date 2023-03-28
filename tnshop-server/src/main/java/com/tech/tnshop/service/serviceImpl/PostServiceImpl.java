package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.entity.Post;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.repository.IPostRepository;
import com.tech.tnshop.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;

    public Post getPostById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find the post " + id));
    }
}
