package com.tech.tnshop.repository;

import com.tech.tnshop.entity.CommentImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT * FROM shop_service.comment_image WHERE comment_id = :commentId", nativeQuery = true)
    List<CommentImage> getAllByCommentId(@Param("commentId") String commentId);
}
