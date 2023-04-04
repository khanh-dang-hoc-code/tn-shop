package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.order_items.AddNewOrderItemRequest;
import com.tech.tnshop.entity.OrderItems;
import com.tech.tnshop.helper.StringHelper;

/*
 * @created 02/04/2023 - 17:48
 * @project tn-shop
 * @author  ngockhanh
 */
public class OrderItemMapper {
    private OrderItemMapper () {

    }
    public static OrderItems mapToOrderItemsEntity(AddNewOrderItemRequest request) {
        return OrderItems.builder()
                .quantity(request.getQuantity())
                .build();
    }
}
