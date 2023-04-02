package com.tech.tnshop.repository;

import com.tech.tnshop.entity.BrandImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 02/04/2023 - 20:11
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IBrandImageRepository extends JpaRepository<BrandImage, String> {
    void deleteByImageName(String imageName);
    @Query(value = "SELECT * FROM shop_service.brand_image WHERE brand_id = :brandId", nativeQuery = true)
    List<BrandImage> getAllByBrandId(@Param("brandId") String brandId);
}
