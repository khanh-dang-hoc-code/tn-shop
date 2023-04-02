package com.tech.tnshop.repository;

import com.tech.tnshop.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 02/04/2023 - 20:13
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IPostImageRepository extends JpaRepository<PostImage, String> {
    void deleteByImageName(String imageName);

    @Query(value = "SELECT * FROM shop_service.post_image WHERE post_id = :postId", nativeQuery = true)
    List<PostImage> getAllByPostId(@Param("postId") String postId);
}
