package com.tech.tnshop.service.serviceImpl;

import com.tech.tnshop.dto.request.AddNewImageRequest;
import com.tech.tnshop.entity.Review;
import com.tech.tnshop.entity.ReviewImage;
import com.tech.tnshop.repository.IReviewImageRepository;
import com.tech.tnshop.service.IReviewImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 02/04/2023 - 20:35
 * @project tn-shop
 * @author  ngockhanh
 */
@Component
@RequiredArgsConstructor
public class ReviewImageServiceImpl implements IReviewImageService {

    private final IReviewImageRepository repository;

    @Override
    public void saveImageToBrand(Review review, AddNewImageRequest request) {
        ReviewImage reviewImage = ReviewImage.builder()
                .url(request.getUrl())
                .imageName(request.getName())
                .reviewImage(review)
                .build();

        repository.save(reviewImage);
    }

    @Override
    public void deleteImage(String imageName) {
        repository.deleteByImageName(imageName);
    }

    @Override
    public List<ReviewImage> getImages(String parentId) {
        return repository.getAllByReviewImage(parentId);
    }
}
