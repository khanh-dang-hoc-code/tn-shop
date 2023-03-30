package com.tech.tnshop.service;

import com.tech.tnshop.entity.Order;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IPaymentService {
    ResponseEntity<Object> checkoutToPaymentPage(HttpServletRequest request, Order order);
    ResponseEntity<Object> refund(String orderId);
}
