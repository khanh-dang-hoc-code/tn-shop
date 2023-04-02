package com.tech.tnshop.service;

import com.tech.tnshop.entity.Order;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Service
public interface IPaymentService {
    ResponseEntity<Object> checkoutToPaymentPage(HttpServletRequest request, Order order);
    ResponseEntity<Object> refund(String orderId);
}
