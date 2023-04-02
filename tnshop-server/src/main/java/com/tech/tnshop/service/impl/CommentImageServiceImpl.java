package com.tech.tnshop.service.impl;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.entity.Comment;
import com.tech.tnshop.entity.CommentImage;
import com.tech.tnshop.repository.ICommentImageRepository;
import com.tech.tnshop.service.ICommentImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 02/04/2023 - 20:34
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class CommentImageServiceImpl implements ICommentImageService {

    private final ICommentImageRepository repository;

    @Override
    public void saveImageToBrand(Comment comment, AddNewImageRequest request) {
        CommentImage commentImage = CommentImage.builder()
                .url(request.getUrl())
                .imageName(request.getName())
                .imageUrl(comment)
                .build();

        repository.save(commentImage);
    }

    @Override
    public void deleteImage(String imageName) {
        repository.deleteByImageName(imageName);
    }

    @Override
    public List<CommentImage> getImages(String parentId) {
        return repository.getAllByCommentId(parentId);
    }
}
