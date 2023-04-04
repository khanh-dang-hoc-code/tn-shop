package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.dto.request.order.AddNewOrderRequest;
import com.tech.tnshop.dto.request.order.UpdateOrderRequest;
import com.tech.tnshop.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${user-auth}/order")
@RequiredArgsConstructor
public class UserOrderController {
    private final OrderServiceImpl orderService;

    @PostMapping("/add")
    public ResponseEntity<Object> createNewOrder(@RequestBody AddNewOrderRequest request) {
        return orderService.createNewOrder(request);
    }

    @GetMapping("/get-list")
    public ResponseEntity<Object> getAllOrder(@RequestParam int index, @RequestParam int limit, HttpServletRequest request) {
        return orderService.getAllOrder(request, index,limit);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getOrder(@RequestParam String orderId) {
        return orderService.findOrderById(orderId);
    }

    @GetMapping("/order-item")
    public ResponseEntity<Object> getOrderItemsInOrder(@RequestParam String orderId) {
        return orderService.getAllOrderItemsInOrder(orderId);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateOrder(@RequestBody UpdateOrderRequest request) {
        return orderService.update(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteOrder(@RequestParam String orderId, HttpServletRequest request) {
        return orderService.removeOrder(request,orderId);
    }
}
