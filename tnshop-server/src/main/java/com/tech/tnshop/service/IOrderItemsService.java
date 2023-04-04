package com.tech.tnshop.service;

import com.tech.tnshop.dto.request.order_items.AddNewOrderItemRequest;
import com.tech.tnshop.dto.request.order_items.UpdateOrderItemRequest;
import com.tech.tnshop.entity.OrderItems;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface IOrderItemsService {

    ResponseEntity<Object> addNewOrderItem(AddNewOrderItemRequest request);

    ResponseEntity<Object> updateOrderItem(UpdateOrderItemRequest request);
    ResponseEntity<Object> removeOrderItem(String orderItem);
    ResponseEntity<Object> removeAllOrderItemInOrder(List<String> orderIds);
    List<OrderItems> getAllOrderItemsInOrder(String orderId);
    List<OrderItems> getAllOrderItemsInCart(String cartId);
}
