package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.comment.AddNewCommentRequest;
import com.tech.tnshop.entity.Comment;

public class CommentMapper {
    public static Comment mapCommentRequestToEntity(AddNewCommentRequest request) {
        return Comment.builder()
                .content(request.getContent())
                .build();
    }
}
