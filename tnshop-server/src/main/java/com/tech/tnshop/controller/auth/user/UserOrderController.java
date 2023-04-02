package com.tech.tnshop.controller.auth.user;

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

    @GetMapping
    public ResponseEntity<Object> getAllOrder(@RequestParam int index, @RequestParam int limit, HttpServletRequest request) {
        return orderService.getAllOrder(request, index,limit);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteOrder(@RequestParam String orderId, HttpServletRequest request) {
        return orderService.removeOrder(request,orderId);
    }
}
