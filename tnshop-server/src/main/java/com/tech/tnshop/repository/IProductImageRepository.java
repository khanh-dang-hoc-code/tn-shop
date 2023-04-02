package com.tech.tnshop.repository;

import com.tech.tnshop.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 02/04/2023 - 20:13
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, String> {
    void deleteByImageName(String imageName);

    List<ProductImage> getAllByProductImage(String productImageId);
}
