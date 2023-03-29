package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.orderItems.AddNewOrderItemRequest;
import com.tech.tnshop.dto.request.orderItems.UpdateOrderItemRequest;
import com.tech.tnshop.entity.Order;
import com.tech.tnshop.entity.OrderItems;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public interface IOrderItemsService {

    ResponseEntity<Object> addNewOrderItem(AddNewOrderItemRequest request);

    ResponseEntity<Object> updateOrderItem(UpdateOrderItemRequest request);
    ResponseEntity<Object> removeOrderItem(String orderItem);
    ResponseEntity<Object> removeAllOrderItemInOrder(List<String> orderIds);
    List<OrderItems> getAllOrderItemsInOrder(Order order);
}
