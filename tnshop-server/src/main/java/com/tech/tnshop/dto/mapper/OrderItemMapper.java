package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.orderItems.AddNewOrderItemRequest;
import com.tech.tnshop.entity.OrderItems;

/*
 * @created 02/04/2023 - 17:48
 * @project tn-shop
 * @author  ngockhanh
 */
public class OrderItemMapper {
    public static OrderItems mapToOrderItemsEntity(AddNewOrderItemRequest request) {
        return OrderItems.builder()
                .build();
    }
}
