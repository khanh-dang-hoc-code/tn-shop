package com.tech.tnshop.controller.auth.user;

import com.tech.tnshop.dto.request.order.UpdateOrderRequest;
import com.tech.tnshop.service.impl.ReviewServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 09:38
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${user-auth}/review")
@RequiredArgsConstructor
public class UserReviewController {
    private final ReviewServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<Object> craeteNewReview(@RequestParam int index, @RequestParam int limit, HttpServletRequest request) {
        return null;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllReviewInProduct(@RequestParam int index, @RequestParam int limit, HttpServletRequest request) {
        return null;
    }

    @GetMapping("/order-item")
    public ResponseEntity<Object> getReviewInProduct(@RequestParam String orderId) {
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateReviewInProduct(@RequestBody UpdateOrderRequest request) {
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteReviewInProduct(@RequestParam String orderId, HttpServletRequest request) {
        return null;
    }
}
