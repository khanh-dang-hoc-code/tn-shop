package com.tech.tnshop.repository;

import com.tech.tnshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IProductRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT * FROM shop_service.product " +
            "WHERE (brand_id = :brandId or :brandId IS NULL) " +
            "AND (category_id = :categoryId or :categoryId IS NULL) " +
            "AND (sale_event_id = :saleEventId or :saleEventId IS NULL) " +
            "AND (color = :color or :color IS NULL) " +
            "AND (size = :size or :size IS NULL) " +
            "ORDER BY " +
            "CASE " +
            "WHEN :sortByName = 'asc' THEN `name` END ASC, " +
            "CASE " +
            "WHEN :sortByName = 'desc' THEN `name` END DESC, " +
            "CASE " +
            "WHEN :sortByPrice = 'asc' THEN price_sold END ASC, " +
            "CASE " +
            "WHEN :sortByPrice = 'desc' THEN price_sold END DESC, " +
            "CASE " +
            "WHEN :sortByCreateAt = 'asc' THEN created_at END ASC, " +
            "CASE " +
            "WHEN :sortByCreateAt = 'desc' THEN created_at END DESC " +
            "LIMIT :limit OFFSET :index", nativeQuery = true)
    List<Product> pagenation(@Param("categoryId") String categoryId, @Param("brandId") String brandId,
                             @Param("index") int index, @Param("limit") int limit, @Param("sortByName") String sortByName,
                             @Param("sortByPrice") String sortByPrice, @Param("sortByCreateAt") String sortByCreateDate,
                             @Param("saleEventId") String saleEventId, @Param("color") String color, @Param("size") String size);

}
