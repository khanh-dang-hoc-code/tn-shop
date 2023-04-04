package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.dto.request.order.RemoveListOrderItemsRequest;
import com.tech.tnshop.dto.request.order_items.AddNewOrderItemRequest;
import com.tech.tnshop.dto.request.order_items.UpdateOrderItemRequest;
import com.tech.tnshop.service.impl.OrderItemsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 09:35
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${user-auth}/order-items")
@RequiredArgsConstructor
public class UserOrderItemsController {

    private final OrderItemsServiceImpl service;

    @PostMapping("/add")
    ResponseEntity<Object> addNewOrderItem(@RequestBody AddNewOrderItemRequest request) {
        return service.addNewOrderItem(request);
    }
    @PutMapping("/update")
    ResponseEntity<Object> updateOrderItem(@RequestBody UpdateOrderItemRequest request) {
        return service.updateOrderItem(request);
    }
    @DeleteMapping("/delete")
    ResponseEntity<Object> removeOrderItem(@RequestParam String orderItemsId) {
        return service.removeOrderItem(orderItemsId);
    }
    @DeleteMapping("delete-list")
    ResponseEntity<Object> removeAllOrderItemInOrder(@RequestBody RemoveListOrderItemsRequest request) {
        return service.removeAllOrderItemInOrder(request.getIds());
    }
}
