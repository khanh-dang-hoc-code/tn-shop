package com.tech.tnshop.repository;

import com.tech.tnshop.entity.ReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 02/04/2023 - 20:15
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IReviewImageRepository extends JpaRepository<ReviewImage, String> {
    void deleteByImageName(String imageName);

    List<ReviewImage> getAllByReviewImage(String reviewImageId);
}
