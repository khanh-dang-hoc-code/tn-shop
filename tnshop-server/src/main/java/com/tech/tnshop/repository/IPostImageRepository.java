package com.tech.tnshop.repository;

import com.tech.tnshop.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
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

    List<PostImage> getAllByPostImage(String postImageId);
}
