package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.service.serviceImpl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/force-auth/user/order")
@RequiredArgsConstructor
public class OrderController {
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
