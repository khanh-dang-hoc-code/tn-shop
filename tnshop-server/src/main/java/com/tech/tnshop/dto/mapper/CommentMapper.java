package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.comment.AddNewCommentRequest;
import com.tech.tnshop.entity.Comment;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public class CommentMapper {
    public static Comment mapCommentRequestToEntity(AddNewCommentRequest request) {
        return Comment.builder()
                .content(request.getContent())
                .build();
    }
}
