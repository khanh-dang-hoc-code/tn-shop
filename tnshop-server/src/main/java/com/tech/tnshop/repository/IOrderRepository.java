package com.tech.tnshop.repository;

import com.tech.tnshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
    @Query(value = "SELECT * FROM shop_service.orders WHERE user_id = :userId LIMIT :limit OFFSET :index",
            countQuery = "SELECT COUNT(*) FROM shop_service.orders", nativeQuery = true)
    List<Order> getAllByUserOrder(@Param("userId") String userId, @Param("limit") int limit, @Param("index") int index);

    @Query(value = "SELECT * FROM shop_service.orders WHERE user_id = :userId AND id = :orderId", nativeQuery = true)
    Optional<Order> findById(@Param("userId") String userId, @Param("orderId") String orderId);

    @Query(value = "SELECT * FROM shop_service.orders WHERE user_id = :userId ", nativeQuery = true)
    List<Order> getAllByUser(@Param("userId") String userId);

}
