package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.order.AddNewOrderRequest;
import com.tech.tnshop.entity.Order;

/*
 * @created 02/04/2023 - 17:50
 * @project tn-shop
 * @author  ngockhanh
 */
public class OrderMapper {
    private OrderMapper () {

    }
    public static Order mapToOrderEntity(AddNewOrderRequest request) {
        return Order.builder()
                .build();
    }
}
