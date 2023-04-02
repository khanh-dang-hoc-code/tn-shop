package com.tech.tnshop.repository;

import com.tech.tnshop.entity.CommentImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 02/04/2023 - 20:12
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface ICommentImageRepository extends JpaRepository<CommentImage, String> {

    void deleteByImageName(String imageName);
    List<CommentImage> getAllByCommentImage(String commentImageId);
}
