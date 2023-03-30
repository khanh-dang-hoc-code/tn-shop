package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.mapper.CommentMapper;
import com.tech.tnshop.dto.request.comment.AddNewCommentRequest;
import com.tech.tnshop.dto.request.comment.UpdateCommentRequest;
import com.tech.tnshop.entity.Comment;
import com.tech.tnshop.entity.Post;
import com.tech.tnshop.entity.User;
import com.tech.tnshop.exception.NotFoundException;
import com.tech.tnshop.helper.StringHelper;
import com.tech.tnshop.repository.ICommentRepository;
import com.tech.tnshop.service.ICommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {
    private final ICommentRepository commentRepository;
    private final AuthenticateService authenticateService;
    private final PostServiceImpl postService;

    @Override
    public ResponseEntity<Object> getAllComment(String postId,int index, int limit) {
        Pageable pageable = PageRequest.of(index, limit, Sort.by("createDate").descending());
        List<Comment> commentList =  commentRepository.findCommentByPostCommentIdOrderByCreateDateDesc(postId, pageable).getContent();
        return ResponseEntity.ok(commentList);
    }

    @Override
    public ResponseEntity<Object> addNewComment(HttpServletRequest servletRequest, AddNewCommentRequest request) {
        User user = authenticateService.getUserFromToken(servletRequest);
        Post post = postService.getPostById(request.getPostId());
        Comment comment = CommentMapper.mapCommentRequestToEntity(request);
        comment.setPostComment(post);
        comment.setUserComment(user);
        commentRepository.save(comment);
        return ResponseEntity.ok("Add new comment successfully");
    }

    @Override
    public ResponseEntity<Object> updateComment(HttpServletRequest servletRequest, UpdateCommentRequest request) {
        Comment comment = getCommentById(request.getCommentId());
        if (StringHelper.isNotEmpty(request.getContent())) {
            comment.setContent(request.getContent());
        }
        commentRepository.save(comment);
        return ResponseEntity.ok("Update comment successfully");
    }

    @Override
    public ResponseEntity<Object> removeComment(HttpServletRequest servletRequest, String commentId) {
        Comment comment = getCommentById(commentId);
        commentRepository.delete(comment);
        return ResponseEntity.ok("Delete comment successfully");
    }

    public Comment getCommentById(String commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Can not find comment " + commentId));
    }
}
