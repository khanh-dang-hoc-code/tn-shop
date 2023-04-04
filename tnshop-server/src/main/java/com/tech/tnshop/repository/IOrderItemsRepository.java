package com.tech.tnshop.repository;

import com.tech.tnshop.entity.OrderItems;
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
public interface IOrderItemsRepository extends JpaRepository<OrderItems, String> {

    @Query(value = "SELECT * FROM shop_service.order_items WHERE order_id = :orderId", nativeQuery = true)
    List<OrderItems> getALlOrderItemsInOrder(@Param("orderId") String orderId);

    @Query(value = "SELECT * FROM shop_service.order_items WHERE cart_id = :cartId", nativeQuery = true)
    List<OrderItems> getALlOrderItemsInCart(@Param("cartId") String cartId);
}
