package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.entity.PostImage;
import com.tech.tnshop.repository.IPostImageRepository;
import com.tech.tnshop.service.IPostImageService;
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
public class PostImageServiceImpl implements IPostImageService {

    private final IPostImageRepository repository;

    @Override
    public void saveImageToBrand(AddNewImageRequest request) {
        PostImage postImage = PostImage.builder()
                .url(request.getUrl())
                .imageName(request.getName())
                .build();

        repository.save(postImage);
    }

    @Override
    public void deleteImage(String imageName) {
        repository.deleteByImageName(imageName);
    }

    @Override
    public List<PostImage> getImages(String parentId) {
        return repository.getAllByPostImage(parentId);
    }
}
