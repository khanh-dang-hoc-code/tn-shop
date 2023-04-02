package com.tech.tnshop.repository;

import com.tech.tnshop.entity.ReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT * FROM shop_service.review_image WHERE review_id = :reviewId", nativeQuery = true)
    List<ReviewImage> getAllByReviewId(@Param("reviewId") String reviewId);
}
