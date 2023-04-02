package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.post.AddNewPostRequest;
import com.tech.tnshop.entity.Post;

/*
 * @created 02/04/2023 - 17:55
 * @project tn-shop
 * @author  ngockhanh
 */
public class PostMapper {
    public static Post mapToPostEntity(AddNewPostRequest request) {
        return Post.builder()

                .build();
    }
}
