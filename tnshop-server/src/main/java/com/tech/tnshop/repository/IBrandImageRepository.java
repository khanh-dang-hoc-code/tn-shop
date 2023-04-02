package com.tech.tnshop.repository;

import com.tech.tnshop.entity.BrandImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * @created 02/04/2023 - 20:11
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IBrandImageRepository extends JpaRepository<BrandImage, String> {
    void deleteByImageName(String imageName);
    List<BrandImage> getAllByBrandImage(String brandId);
}
