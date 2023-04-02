package com.tech.tnshop.repository;

import com.tech.tnshop.entity.CategoryImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 02/04/2023 - 20:12
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface ICategoryImageRepository extends JpaRepository<CategoryImage, String> {
    void deleteByImageName(String imageName);
    List<CategoryImage> getAllByCategoryImage(String categoryId);
}
